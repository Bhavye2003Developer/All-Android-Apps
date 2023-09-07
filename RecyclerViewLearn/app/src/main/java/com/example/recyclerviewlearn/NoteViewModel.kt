package com.example.recyclerviewlearn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NoteViewModel : ViewModel() {


    private var _noteList = MutableLiveData<MutableList<Note>>()
    val noteList: LiveData<MutableList<Note>>
        get() = _noteList

    init {
        _noteList.value = arrayListOf()
    }

    fun addNote(note: Note) {
        val currentList = _noteList.value
        currentList?.add(note)
        _noteList.value = currentList
    }

}