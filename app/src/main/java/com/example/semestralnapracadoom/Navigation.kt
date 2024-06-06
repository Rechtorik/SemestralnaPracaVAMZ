package com.example.semestralnapracadoom

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.semestralnapracadoom.ui.interestingFacts.InterestingFactsScreen
import com.example.semestralnapracadoom.ui.lore.LoreScreen
import com.example.semestralnapracadoom.ui.mainMenu.MainMenu
import com.example.semestralnapracadoom.ui.monsters.MonstersMain
import com.example.semestralnapracadoom.ui.quiz.QuizScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main_menu") {
        composable(route = "main_menu") {
            MainMenu(navController)
        }
        composable(route = "monsters") {
            MonstersMain(navController)
        }
        composable(route = "lore") {
            LoreScreen(navController = navController)
        }
        composable(route = "quiz") {
            QuizScreen(navController = navController)
        }
        composable(route = "interesting_facts") {
            InterestingFactsScreen(navController = navController)
        }
    }
}