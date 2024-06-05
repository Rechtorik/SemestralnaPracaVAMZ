package com.example.semestralnapracadoom.ui.lore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.semestralnapracadoom.ui.quiz.QuizUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class LoreViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        LoreUiState()
    )
    val uiState: StateFlow<LoreUiState> = _uiState.asStateFlow()

    init {
        glowingBackground()
    }

    fun glowingBackground() {
        viewModelScope.launch {
            while (isActive) {
                delay(50) // Pozastaví korutinu na 250 milisekúnd
                if (_uiState.value.backward) {
                    _uiState.update {currentState ->
                        currentState.copy(
                            value = currentState.value - 20,
                        )
                    }
                    if (_uiState.value.value < 0) {
                        _uiState.update {currentState ->
                            currentState.copy(
                                backward = false
                            )
                        }
                    }

                } else {
                    _uiState.update {currentState ->
                        currentState.copy(
                            value = currentState.value + 20,
                        )
                    }
                    if (_uiState.value.value > 1000) {
                        _uiState.update {currentState ->
                            currentState.copy(
                                backward = true
                            )
                        }
                    }
                }
            }
        }
    }
}