package com.example.quizapp

class QuestionList {
    private val questionArray = listOf(
        Question(
            1,
            "What is the capital of France?",
            arrayListOf("Berlin", "Madrid", "Paris", "Rome"),
            "Paris"
        ),
        Question(
            2,
            "Which planet is known as the Red Planet?",
            arrayListOf("Earth", "Mars", "Venus", "Jupiter"),
            "Mars"
        ),
        Question(
            3,
            "Which gas do plants primarily use for photosynthesis?",
            arrayListOf("Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen"),
            "Carbon Dioxide"
        ),
        Question(
            4,
            "Which famous scientist developed the theory of relativity?",
            arrayListOf("Isaac Newton", "Albert Einstein", "Stephen Hawking", "Nikola Tesla"),
            "Albert Einstein"
        ),
        Question(
            5,
            "What is the largest mammal on Earth?",
            arrayListOf("Elephant", "Giraffe", "Blue Whale", "Hippopotamus"),
            "Blue Whale"
        ),
        Question(
            6,
            "What is the chemical symbol for the element Gold?",
            arrayListOf("Ag", "Au", "Fe", "Cu"),
            "Au"
        )
    )


    fun getRandomQuestion() : Question{
        val notShownIDs = getRandom()
        val randomQuestionID = notShownIDs.random()
        questionArray[randomQuestionID-1].isShown = true
        return questionArray[randomQuestionID-1]
    }

    fun getRandom(): MutableList<Int> {
        val ids = mutableListOf<Int>()
        questionArray.filter { question: Question -> !question.isShown }.forEach {
            ids.add(it.questionID)
        }
        return ids
    }
}