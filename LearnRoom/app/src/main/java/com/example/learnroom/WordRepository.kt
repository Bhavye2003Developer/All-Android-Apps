package com.example.learnroom

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDAO: WordDAO) {

    val allWords: Flow<List<Word>> = wordDAO.getWordsSorted()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word){
        wordDAO.insert(word)
    }

}