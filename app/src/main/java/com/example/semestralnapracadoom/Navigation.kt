package com.example.semestralnapracadoom

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.semestralnapracadoom.ui.IDSoftware.IDSoftwareScreen
import com.example.semestralnapracadoom.ui.interestingFacts.InterestingFactsScreen
import com.example.semestralnapracadoom.ui.lore.LoreScreen
import com.example.semestralnapracadoom.ui.mainMenu.MainMenuScreen
import com.example.semestralnapracadoom.ui.monsters.MonstersMain
import com.example.semestralnapracadoom.ui.quiz.QuizScreen

enum class NavRoute(val route: String) {
    MAIN_MENU("main_menu"),
    MONSTERS("monsters"),
    LORE("lore"),
    QUIZ("quiz"),
    INTERESTING_FACTS("interesting_facts"),
    ID_SOFTWARE("id_software")
}


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main_menu") {
        composable(route = NavRoute.MAIN_MENU.route) {
            MainMenuScreen(navController)
        }
        composable(route = NavRoute.MONSTERS.route) {
            MonstersMain(navController)
        }
        composable(route = NavRoute.LORE.route) {
            LoreScreen(navController = navController)
        }
        composable(route = NavRoute.QUIZ.route) {
            QuizScreen(navController = navController)
        }
        composable(route = NavRoute.INTERESTING_FACTS.route) {
            InterestingFactsScreen(navController = navController)
        }
        composable(route = NavRoute.ID_SOFTWARE.route) {
            IDSoftwareScreen(navController = navController)
        }
    }
}