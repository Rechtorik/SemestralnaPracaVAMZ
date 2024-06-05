package com.example.semestralnapracadoom.ui.monsters

data class Monster(
    val name: String,
    val description: String,
    val image0ResId: Int,
    val image1ResId: Int,
    val image2ResId: Int,
    val image3ResId: Int,
    var imageResId: Int
)