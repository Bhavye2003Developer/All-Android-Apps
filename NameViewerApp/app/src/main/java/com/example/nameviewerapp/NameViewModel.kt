package com.example.nameviewerapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameViewModel : ViewModel() {

    private val _allNotes: MutableLiveData<String> by lazy {
        MutableLiveData<String>("")
    }

    val allNotes: LiveData<String>
        get() = _allNotes

    fun addNote(note: String) {
        _allNotes.value = _allNotes.value + "\n$note"
    }
}