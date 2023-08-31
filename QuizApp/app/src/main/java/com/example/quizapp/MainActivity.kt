package com.example.quizapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

const val numberOfQuestionsInQuiz = 5
val questionStatus = QuestionStatus(NumberOfCorrectQuestions = 0, NumberOfQuestionsLeft = numberOfQuestionsInQuiz)
val questionObject = QuestionList()

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionStatus.decrementQuestion()

        val newQuestionFragment = QuestionFragment.newInstance(questionObject.getRandomQuestion())
//        Toast.makeText(this, questionObject.getRandom().toString(), Toast.LENGTH_SHORT).show()

        val fragTransaction = supportFragmentManager.beginTransaction()
        fragTransaction.replace(R.id.frameLayout, newQuestionFragment)
        fragTransaction.commit()
    }
}