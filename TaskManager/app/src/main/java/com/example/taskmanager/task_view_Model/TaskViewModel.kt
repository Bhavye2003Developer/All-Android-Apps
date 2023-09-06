package com.example.taskmanager.task_view_Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.taskmanager.TaskRepository
import com.example.taskmanager.task_room.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {

    val allTasks: LiveData<List<Task>> = repository.allTasks

    suspend fun insertTask(task: Task) = withContext(Dispatchers.IO) {
        repository.insertTask(task)
    }

    suspend fun deleteTask(task: Task) = withContext(Dispatchers.IO) {
        repository.deleteTask(task)
    }

    suspend fun markTaskDone(task_id:Long) = withContext(Dispatchers.IO){
        repository.markTaskDone(task_id)
    }
}