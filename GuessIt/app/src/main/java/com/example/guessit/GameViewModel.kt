package com.example.guessit

import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    val words = Words()

    init {
        Log.d("View_model", "GameView model created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("View_model", "GameView model destroyed")
    }

}