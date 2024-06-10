package com.example.semestralnapracadoom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.semestralnapracadoom.ui.IDSoftware.IDSoftwareScreen
import com.example.semestralnapracadoom.ui.glowingBackground.GlowingBackgroundViewModel
import com.example.semestralnapracadoom.ui.interestingFacts.InterestingFactsScreen
import com.example.semestralnapracadoom.ui.lore.LoreScreen
import com.example.semestralnapracadoom.ui.mainMenu.MainMenuScreen
import com.example.semestralnapracadoom.ui.monsters.MonstersMain
import com.example.semestralnapracadoom.ui.myPlay.MyPlayNotesScreen
import com.example.semestralnapracadoom.ui.myPlay.MyPlayScreen
import com.example.semestralnapracadoom.ui.myPlay.MyPlaylViewModel
import com.example.semestralnapracadoom.ui.quiz.QuizScreen

enum class NavRoute(val route: String) {
    MAIN_MENU("main_menu"),
    MONSTERS("monsters"),
    LORE("lore"),
    QUIZ("quiz"),
    INTERESTING_FACTS("interesting_facts"),
    ID_SOFTWARE("id_software"),
    MY_PLAY("my_play"),
    MY_PLAY_NOTES("my_play_notes")
}


@Composable
fun Navigation() {
    val navController = rememberNavController()
    val myPlaylViewModel: MyPlaylViewModel = viewModel()

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
        composable(route = NavRoute.MY_PLAY.route) {
            MyPlayScreen(navController = navController, myPlayViewModel = myPlaylViewModel)
        }
        composable(route = NavRoute.MY_PLAY_NOTES.route) {
            MyPlayNotesScreen(navController = navController, myPlaylViewModel = myPlaylViewModel)
        }
    }
}