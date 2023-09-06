package com.example.taskmanager.task_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.taskmanager.TaskRepository
import com.example.taskmanager.task_room.TaskDao
import com.example.taskmanager.task_room.database.TaskDatabase
import com.example.taskmanager.task_view_Model.TaskViewModel
import com.example.taskmanager.task_view_Model.TaskViewModelFactory

open class TaskBaseFragment(private val layoutId : Int) : Fragment(layoutId) {

    lateinit var viewModel : TaskViewModel
    private lateinit var repository: TaskRepository
    lateinit var taskDao: TaskDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val applicationContext = requireContext().applicationContext
        taskDao = TaskDatabase.getInstance(applicationContext).taskDao()
        repository = TaskRepository(taskDao)
        viewModel = ViewModelProvider(this, TaskViewModelFactory(repository))[TaskViewModel::class.java]
    }

}