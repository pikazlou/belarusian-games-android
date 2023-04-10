package by.edu.games.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.edu.games.data.Words

@Composable
fun ContextoScreen(onBackClick: () -> Unit) {
    var wordInput: String by rememberSaveable { mutableStateOf("") }
    var discoveredWords: List<String> by rememberSaveable { mutableStateOf(listOf<String>()) }
    if (wordInput in Words.words && wordInput !in discoveredWords) {
        discoveredWords = discoveredWords.plus(wordInput)
    }
    ContextoUi(wordInput, {wordInput = it}, discoveredWords, onBackClick)
}

@Composable
fun ContextoUi(
    inputValue: String,
    onInputChanged: (String) -> Unit,
    discoveredWords: List<String>,
    onBackClick: () -> Unit
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(24.dp)) {
        OutlinedTextField(
            value = inputValue,
            onValueChange = onInputChanged,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Напішы слова") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        for (w in discoveredWords) {
            GuessedWord(w, Words.words[w] ?: 1, Words.words.size)
        }
        Button(onClick = onBackClick) {
            Text("Назад")
        }
    }
}

@Composable
fun GuessedWord(word: String, place: Int, totalWordCount: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(38.dp)
            .padding(0.dp, 3.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRoundRect(
                color = Color(0xE6, 0xE6, 0xE6),
                cornerRadius = CornerRadius(20F, 20F)
            )

            val relativePlace = place.toFloat() / totalWordCount
            val gaugeSize = size.copy(width = size.width * relativePlace)
            val color = when {
                relativePlace < 0.3 -> Color(0xDD, 0x99, 0x99)
                0.3 <= relativePlace && relativePlace < 0.6 -> Color(0xDD, 0xDD, 0x66)
                else -> Color(0x99, 0xDD, 0xAA)
            }
            drawRoundRect(
                color = color,
                size = gaugeSize,
                cornerRadius = CornerRadius(20F, 20F)
            )

            /*drawRoundRect(
                style = Stroke(width = 5F),
                color = Color(0x66, 0x66, 0x66),
                cornerRadius = CornerRadius(20F, 20F)
            )*/
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(16.dp, 0.dp, 16.dp, 2.dp)
        ) {
            Text(word)
            Text(place.toString())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContextoScreenPreview() {
    ContextoUi("гарбата", {}, listOf("парасон", "чаканне", "кавярня"), {})
}