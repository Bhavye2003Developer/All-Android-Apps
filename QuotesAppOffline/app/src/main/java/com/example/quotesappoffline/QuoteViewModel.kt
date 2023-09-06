package com.example.quotesappoffline

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuoteViewModel : ViewModel() {

    private val quotes: Quotes = Quotes()

    private val _currentQuote: MutableLiveData<String> by lazy {
        MutableLiveData<String>(quotes.getQuote())
    }

    val currentQuote: LiveData<String>
        get() = _currentQuote

    fun newQuote() {
        _currentQuote.value = quotes.getQuote()
        while (_currentQuote.value == quotes.getQuote()) {
            _currentQuote.value = quotes.getQuote()
        }
    }

}