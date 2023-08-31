package com.example.quizapp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class Submit_fragment : Fragment(R.layout.submit_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val showResult = view.findViewById<TextView>(R.id.showResult)
        showResult.text = "Number of Correct Answers : ${questionStatus.NumberOfCorrectQuestions}"
    }
}