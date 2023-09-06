package com.example.taskmanager

import androidx.lifecycle.LiveData
import com.example.taskmanager.task_room.TaskDao
import com.example.taskmanager.task_room.Task

class TaskRepository(private val taskDao: TaskDao) {
    val allTasks: LiveData<List<Task>> = taskDao.getAllTasks()

    @Suppress("RedundantSuspendModifier")
    suspend fun insertTask(task: Task){
        taskDao.insertTask(task)
    }

    @Suppress("RedundantSuspendModifier")
    suspend fun deleteTask(task: Task){
        taskDao.deleteTask(task)
    }

    @Suppress("RedundantSuspendModifier")
    suspend fun markTaskDone(task_id: Long){
        taskDao.markTaskDone(task_id)
    }
}