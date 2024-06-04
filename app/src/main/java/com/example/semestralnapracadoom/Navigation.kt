package com.example.semestralnapracadoom

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.semestralnapracadoom.ui.lore.LoreScreen
import com.example.semestralnapracadoom.ui.mainMenu.MainMenu
import com.example.semestralnapracadoom.ui.monsters.MonstersMain

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
    }
}