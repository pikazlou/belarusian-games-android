package by.edu.games

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import by.edu.games.ui.ContextoScreen
import by.edu.games.ui.MainScreen
import by.edu.games.ui.VerseScreen

@Composable
fun GameApp() {

    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.Main.name
    ) {
        composable(route = Screens.Main.name) {
            MainScreen(
                verseClick = {
                    navController.navigate(Screens.Verse.name)
                },
                contextoClick = {
                    navController.navigate(Screens.Contexto.name)
                }
            )
        }
        composable(route = Screens.Verse.name) {
            VerseScreen(
                onClick = {
                    navController.navigate(Screens.Main.name)
                }
            )
        }
        composable(route = Screens.Contexto.name) {
            ContextoScreen(
                onBackClick = {
                    navController.navigate(Screens.Main.name)
                }
            )
        }
    }

}