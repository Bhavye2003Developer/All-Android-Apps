package com.example.wordshow

import androidx.lifecycle.LiveData

class WordRepository(private val wordDao: WordDao) {

    fun getAllWords() : LiveData<List<String>> {
        return wordDao.getWords()
    }

    suspend fun insertWord(word: Word){
        wordDao.insertWord(word)
    }
}