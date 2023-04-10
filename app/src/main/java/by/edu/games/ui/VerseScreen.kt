package by.edu.games.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun VerseScreen(onClick: () -> Unit) {
    Column() {
        Text(text = "Вставай, ідзі паля засевай,\nБо прыйшоў месяц травень!")
        Button(
            onClick = onClick
        ) {
            Text("Назад")
        }
    }

}


@Preview(showBackground = true)
@Composable
fun VerseScreenPreview() {
    VerseScreen({})
}