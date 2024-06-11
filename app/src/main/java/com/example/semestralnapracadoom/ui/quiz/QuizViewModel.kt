package com.example.semestralnapracadoom.ui.quiz

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

class QuizViewModel : ViewModel() {
    val questions = listOf(
        QuizQuestion(
            "Who was lead programmer in ID Software?",
            "John Romero",
            "Gabe Newell",
            "John Carmack"
        ),
        QuizQuestion(
            "What is first title that id software developed?",
            "DOOM",
            "Quake",
            "Commander Keen"
        ),
        QuizQuestion(
            "When was this game released?",
            "1995",
            "1994",
            "1993"
        ),
        QuizQuestion(
            "How many HP has Lost Soul (enemy)?",
            "90",
            "110",
            "100"
        ),
        QuizQuestion(
            "How many demons is in DOOM?",
            "8",
            "7",
            "9"
        ),
        QuizQuestion(
            "What is world record in first level of DOOM?",
            "3,5 seconds",
            "12,3 seconds",
            "7,8 seconds"
        ),
        QuizQuestion(
            "What is the name of player?",
            "Duke Nukem",
            "BJ Blazkowicz",
            "Doomguy"
        ),
        QuizQuestion(
            "What is the most common enemy?",
            "Pinky",
            "Shotgun Guy",
            "Imp"
        ),
        QuizQuestion(
            "Who made levels for DOOM?",
            "Adrian Carmack",
            "Bishop White",
            "John Romero"
        ),
        QuizQuestion(
            "How many games id software developed?",
            "2",
            "6",
            "5"
        ),
        QuizQuestion(
            "What gun was in DOOM II and not in DOOM I?",
            "BFG 9000",
            "Plasma Rifle",
            "Super Shotgun"
        ),
        QuizQuestion(
            "What is name of corporation in DOOM?",
            "Mars mining station",
            "Wayland Yutani",
            "Union Aerospace Corporation"
        ),
        QuizQuestion(
            "Which famous musician composed the music for the original DOOM game?",
            "Slayer",
            "Mick Gordon",
            "Bobby Prince"
        )
    )

    val firstQuestionIndex = Random.nextInt(0, questions.size)
    private val _uiState = MutableStateFlow(
        QuizUiState(
            curQuestion = questions[firstQuestionIndex],
            usedQuestions = mutableListOf(firstQuestionIndex)
        )
    )
    val uiState: StateFlow<QuizUiState> = _uiState.asStateFlow()



    fun GetRandomQuizQuestion(): QuizQuestion {
        var position = Random.nextInt(0, questions.size)
        while (_uiState.value.usedQuestions.contains(position)) {
            position = Random.nextInt(0, questions.size)
        }
        _uiState.value.usedQuestions.add(position)

        val questionToRandomize = questions[position]

        var randomAnswers = listOf(
            questionToRandomize.firstOption,
            questionToRandomize.secondOption,
            questionToRandomize.rightOption
        )
        randomAnswers = randomAnswers.shuffled()
        val rightPosition = when(questionToRandomize.rightOption) {
            randomAnswers[0] -> 0
            randomAnswers[1] -> 1
            else -> 2
        }
        val returnQuestion = QuizQuestion(
            questionToRandomize.question,
            randomAnswers[0],
            randomAnswers[1],
            randomAnswers[2],
            rightPosition
        )
        return returnQuestion
    }

    fun Reset() {
        val firstRandomQuestion = questions[Random.nextInt(0, questions.size)]
        _uiState.update {currentState ->
            currentState.copy(
                score = 0 ,
                curQuestion =  firstRandomQuestion,
                numberOfQuestions = 1 ,
                isGameOver = false ,
                usedQuestions = mutableListOf(questions.indexOf(firstRandomQuestion))
            )
        }
    }


    fun RightAnswer() {
        _uiState.update {currentState ->
            currentState.copy(
                score = currentState.score.inc(),
            )
        }
        ButtonClicked()
    }

    fun ButtonClicked() {
        if (_uiState.value.numberOfQuestions == 10) {
            _uiState.update {currentState ->
                currentState.copy(
                    isGameOver = true
                )
            }
            return
        }
        _uiState.update {currentState ->
            currentState.copy(
                numberOfQuestions = currentState.numberOfQuestions.inc(),
                curQuestion = GetRandomQuizQuestion()
            )
        }
    }
}