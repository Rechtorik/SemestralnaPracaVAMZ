package com.example.semestralnapracadoom.ui.mainMenu

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainMenuViewModel : ViewModel() {
    val nieco: String = "main_menu"
    private val _backgroundColor = mutableStateOf(Color.White)
    val backgroundColor: State<Color> = _backgroundColor

    fun changeBackgroundColor(newColor: Color) {
        _backgroundColor.value = newColor
    }
}