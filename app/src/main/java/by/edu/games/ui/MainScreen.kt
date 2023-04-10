package by.edu.games.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen(verseClick: () -> Unit, contextoClick: () -> Unit) {
    Column() {
        Title()
        Button(
            onClick = verseClick
        ) {
            Text("Чытаем вершык")
        }
        Button(
            onClick = contextoClick
        ) {
            Text("Адгадаць слова")
        }
    }
}

@Composable
fun Title() {
    Text(text = "Вітаю, што робім?")
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen({}, {})
}