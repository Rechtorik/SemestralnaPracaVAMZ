package com.example.semestralnapracadoom.ui.quiz

data class QuizUiState(
    val score: Int = 0 ,
    val curQuestion: QuizQuestion ,
    val numberOfQuestions: Int = 1 ,
    val isGameOver: Boolean = false ,
    var usedQuestions: MutableList<Int> = mutableListOf()
)