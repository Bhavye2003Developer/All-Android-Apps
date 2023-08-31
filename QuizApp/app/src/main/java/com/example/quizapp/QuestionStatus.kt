package com.example.quizapp

data class QuestionStatus(
    var NumberOfQuestionsLeft: Int = 5,
    var NumberOfCorrectQuestions: Int = 0
){
    fun decrementQuestion(){
        --NumberOfQuestionsLeft
    }
    fun correctQuestion(){
        ++NumberOfCorrectQuestions
    }
    fun wrongQuestion(){
        --NumberOfCorrectQuestions
    }
}