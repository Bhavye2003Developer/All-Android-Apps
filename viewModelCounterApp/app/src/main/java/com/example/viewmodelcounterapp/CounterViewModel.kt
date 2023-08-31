package com.example.viewmodelcounterapp

import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private var counter = 0

    fun increment(){
        ++counter
    }

    fun getCount(): Int {
        return counter
    }
}