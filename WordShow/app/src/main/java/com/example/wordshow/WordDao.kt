package com.example.wordshow

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


// To access data from word_table

@Dao
interface WordDao {

    // CRUD
    @Insert
    suspend fun insertWord(word: Word)

    @Delete
    suspend fun deleteWord(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAllWords()


    @Query("SELECT word FROM word_table")
    fun getWords() : LiveData<List<String>>
}