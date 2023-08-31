package com.example.quizapp

data class Question (
    val questionID: Int,
    val question: String,
    val options: ArrayList<String>,
    val answer: String,
    var isShown: Boolean = false
)