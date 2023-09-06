package com.example.taskmanager.task_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.taskmanager.R
import com.example.taskmanager.databinding.NewTaskFragmentBinding
import com.example.taskmanager.task_room.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.util.*

@Suppress("DEPRECATION")
class NewTask : TaskBaseFragment(R.layout.new_task_fragment) {

    private lateinit var binding: NewTaskFragmentBinding
    private var task: String? = null
    private var selectedDate : Long?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.new_task_fragment, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding.calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            selectedDate = Date(year, month, dayOfMonth).time
        }

        binding.buttonCreateTask.setOnClickListener {
            task = binding.task.editableText.toString()

            MainScope().launch(Dispatchers.IO) {
                insertData(0, task!!, currentDate(), selectedDate!!)
            }

            val action = NewTaskDirections.actionNewTaskToMainFragment()
            findNavController().navigate(action)

        }

    }
    private fun currentDate(): Long {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        return calendar.timeInMillis
    }

    private fun insertData(id: Long, user_task: String, start_date: Long, end_date: Long){
        val task = Task(id, task!!, start_date, end_date)
        viewModel.insertTask(task)
    }

}