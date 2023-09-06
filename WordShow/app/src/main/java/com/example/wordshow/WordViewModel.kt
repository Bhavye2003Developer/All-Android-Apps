package com.example.wordshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class WordViewModel(private val wordRepository: WordRepository) : ViewModel() {

    private fun getWords() : LiveData<List<String>>{
        return wordRepository.getAllWords()
    }

    fun insertWord(word: Word){
        MainScope().launch(Dispatchers.IO) {
            wordRepository.insertWord(word)
        }
    }

    private var _allWords : LiveData<List<String>> = getWords()
    val allWords : LiveData<List<String>>
        get() = _allWords
}