package com.example.semestralnapracadoom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.semestralnapracadoom.ui.mainMenu.MainMenu
import com.example.semestralnapracadoom.ui.monsters.MonstersMain
import com.example.semestralnapracadoom.ui.theme.SemestralnaPracaDoomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SemestralnaPracaDoomTheme {
                Surface(
                    modifier = Modifier.fillMaxSize() ,
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                    //MonstersMain()
                    //MainMenu()
                }
            }
        }
    }
}