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
            "John Carmack",
            2
        ),
        QuizQuestion(
            "How is this game called?",
            "Half Life",
            "Alien",
            "Doom",
            2
        ),
        QuizQuestion(
            "Why was this game revolutionary?",
            "It was boring",
            "Nobody liked it",
            "It was fun",
            2
        )
    )
    private val _uiState = MutableStateFlow(
        QuizUiState(
            curQuestion = GetRandomQuizQuestion()
        )
    )
    val uiState: StateFlow<QuizUiState> = _uiState.asStateFlow()

    fun GetRandomQuizQuestion(prevoiusQuestion: QuizQuestion = questions[0]): QuizQuestion {
        var previousQuestionPosition = 0
        questions.forEachIndexed { index, question ->
            if (question.question == prevoiusQuestion.question)
                previousQuestionPosition = index
        }
        //mám pozíciu predošlej otázky

        var position = Random.nextInt(0, questions.size)
        while (previousQuestionPosition == position)
            position = Random.nextInt(0, questions.size)
        //mám novú pozícíu
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
        _uiState.value = QuizUiState(curQuestion = GetRandomQuizQuestion())
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
                curQuestion = GetRandomQuizQuestion(currentState.curQuestion)
            )
        }
    }
}