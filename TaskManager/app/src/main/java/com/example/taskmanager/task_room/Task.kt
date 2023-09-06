package com.example.taskmanager.task_room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val task: String,
    val start_date: Long,
    val end_date: Long,
    @ColumnInfo(name = "isDone", defaultValue = "0") val isDone: Int = 0
)