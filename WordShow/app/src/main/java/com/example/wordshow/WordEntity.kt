package com.example.wordshow

import androidx.room.Entity
import androidx.room.PrimaryKey


// it's a Word Table

@Entity(tableName = "word_table")
data class Word(
    @PrimaryKey(autoGenerate = true) val id: Int, val word: String
)