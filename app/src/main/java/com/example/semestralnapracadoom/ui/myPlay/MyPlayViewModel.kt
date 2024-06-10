package com.example.semestralnapracadoom.ui.myPlay

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.semestralnapracadoom.ui.quiz.QuizUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

class MyPlaylViewModel : ViewModel() {
    val levels = mutableListOf(
        Level(position = 1, name = "E1M1: Hangar"),
        Level(position = 2, name = "E1M2: Nuclear Plant"),
        Level(position = 3, name = "E1M3: Toxin Refinery"),
        Level(position = 4, name = "E1M4: Command Control"),
        Level(position = 5, name = "E1M5: Phobos Lab"),
        Level(position = 6, name = "E1M6: Central Processing"),
        Level(position = 7, name = "E1M7: Computer Station"),
        Level(position = 8, name = "E1M8: Phobos Anomaly"),

        Level(position = 9, name = "E2M1: Deimos Anomaly"),
        Level(position = 10, name = "E2M2: Containment Area"),
        Level(position = 11, name = "E2M3: Refinery"),
        Level(position = 12, name = "E2M4: Deimos Lab"),
        Level(position = 13, name = "E2M5: Command Center"),
        Level(position = 14, name = "E2M6: Halls of the Damned"),
        Level(position = 15, name = "E2M7: Spawning Vats"),
        Level(position = 16, name = "E2M8: Tower of Babel"),

        Level(position = 17, name = "E3M1: Hell Keep"),
        Level(position = 18, name = "E3M2: Slough of Despair"),
        Level(position = 19, name = "E3M3: Pandemonium"),
        Level(position = 20, name = "E3M4: House of Pain"),
        Level(position = 21, name = "E3M5: Unholy Cathedral"),
        Level(position = 22, name = "E3M6: Mt. Erebus"),
        Level(position = 23, name = "E3M7: Limbo"),
        Level(position = 24, name = "E3M8: Dis"),
    )

    private val _uiState = MutableStateFlow(
        MyPlayUiState(level = levels[0])
    )
    val uiState: StateFlow<MyPlayUiState> = _uiState.asStateFlow()


    fun NextLevel() {
        if (_uiState.value.level.position != 24) {
            val nextLevel = levels[_uiState.value.level.position]
            _uiState.update {currentState ->
                currentState.copy(
                    level = nextLevel,
                )
            }
        }
    }

    fun setNote(newNote: String) {
        _uiState.update {currentState ->
            currentState.copy(
                note = newNote,
            )
        }
    }
}