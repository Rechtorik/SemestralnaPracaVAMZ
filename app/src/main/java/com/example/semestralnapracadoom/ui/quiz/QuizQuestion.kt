package com.example.semestralnapracadoom.ui.quiz

data class QuizQuestion (
    val question: String,
    val firstOption: String,
    val secondOption: String,
    val rightOption: String,
    val rightPosition: Int
)