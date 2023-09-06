package com.example.learnroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


// a table in sqlite database
@Entity(tableName = "word_table")
data class Word(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name="word")
    val word: String
    )
