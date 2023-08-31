package com.example.guessit

class Words {
    private val simpleWords = mutableListOf(
        "benevolent",
        "resilient",
        "exuberant",
        "meticulous",
        "voracious",
        "serene",
        "elated",
        "coherent",
        "fervent",
        "plausible"
    )

    fun getNextWord(): String = if (simpleWords.size > 0) {
        val randomWord = simpleWords.random()
        simpleWords.remove(randomWord)
        randomWord
    } else "finished"
}