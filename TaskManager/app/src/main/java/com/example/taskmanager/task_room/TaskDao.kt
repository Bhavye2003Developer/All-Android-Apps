package com.example.taskmanager.task_room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {

    @Query("SELECT * FROM task_table ORDER BY end_date ASC")
    fun getAllTasks(): LiveData<List<Task>>

    @Insert
    fun insertTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Query("UPDATE task_table SET isDone=1 WHERE id=:task_id")
    fun markTaskDone(task_id: Long)
}