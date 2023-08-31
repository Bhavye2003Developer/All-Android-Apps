package com.example.quizapp

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment


@Suppress("DEPRECATION")
class QuestionFragment : Fragment(R.layout.question_fragment) {

    companion object {
        fun newInstance(question: Question): QuestionFragment {
            val f = QuestionFragment()
            // Supply index input as an argument.
            val args = Bundle()
            args.putString("question", question.question)
            args.putStringArrayList("options", question.options)
            args.putString("answer", question.answer)
            f.arguments = args
            return f
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //         create question UI
        val linearlayout = view.findViewById<LinearLayout>(R.id.questionLayout)

        val questionText = TextView(context)
        questionText.text = arguments?.getString("question")

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            gravity = Gravity.CENTER_HORIZONTAL
        }
        params.setMargins(10, 50, 10, 0)
        questionText.layoutParams = params
        questionText.textSize = 25F


        val radioGroup = RadioGroup(context)
        for (optionIndex in 0 until arguments?.getStringArrayList("options")!!.size) {
            val radioButton = RadioButton(context)
            radioButton.text = arguments?.getStringArrayList("options")!![optionIndex]
            radioButton.id = optionIndex
            radioGroup.addView(radioButton)
        }

        val submitButton = Button(context)
        submitButton.text = "Next"
        submitButton.setOnClickListener {
            val radioButtonID = radioGroup.checkedRadioButtonId
            val radioButton = radioGroup.findViewById(radioButtonID) as RadioButton

            val selectedText = radioButton.text as String
//            Toast.makeText(context, "Selected : $selectedText", Toast.LENGTH_SHORT).show()

//            Toast.makeText(
//                context,
//                "Number of questions left : ${questionStatus.NumberOfQuestionsLeft}",
//                Toast.LENGTH_SHORT
//            ).show()

            if (selectedText == arguments?.getString("answer")) {
                questionStatus.correctQuestion()
            }
//            else {
//                questionStatus.wrongQuestion()
//            }

            if (questionStatus.NumberOfQuestionsLeft <= 0) {
//                Toast.makeText(context, "Submitted quiz : ${questionStatus.NumberOfCorrectQuestions}", Toast.LENGTH_SHORT).show()

                val fragTransaction = requireFragmentManager().beginTransaction()
                fragTransaction.replace(R.id.frameLayout, Submit_fragment())
                fragTransaction.commit()

            } else {

                questionStatus.decrementQuestion()

                val newQuestionFragment =
                    newInstance(questionObject.getRandomQuestion())
//                Toast.makeText(context, questionObject.getRandom().toString(), Toast.LENGTH_SHORT).show()

                val fragTransaction = requireFragmentManager().beginTransaction()
                fragTransaction.replace(R.id.frameLayout, newQuestionFragment)
                fragTransaction.commit()
            }
        }
        linearlayout.addView(questionText)
        linearlayout.addView(radioGroup)
        linearlayout.addView(submitButton)
    }
}