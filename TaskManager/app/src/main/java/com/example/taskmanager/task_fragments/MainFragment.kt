package com.example.taskmanager.task_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.taskmanager.OnItemClickListener
import com.example.taskmanager.R
import com.example.taskmanager.adapter.RecyclerViewAdapter
import com.example.taskmanager.databinding.MainFragmentBinding
import com.example.taskmanager.task_room.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainFragment : TaskBaseFragment(R.layout.main_fragment), OnItemClickListener {

    private lateinit var binding: MainFragmentBinding
    private var adapter: RecyclerViewAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)

        if (adapter == null) {
            adapter = context?.let {
                RecyclerViewAdapter(
                    it, emptyList()
                )
            } // Initialize with an empty list
            binding.recyclerViewTask.adapter = adapter
            binding.recyclerViewTask.setHasFixedSize(true)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addTask.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToNewTask()
            findNavController().navigate(action)
        }

        val observer = Observer<List<Task>> {
            adapter?.updateTasks(it)
        }
        viewModel.allTasks.observe(this, observer)
    }

    override fun onDoneTask(task_id: Long) {
        MainScope().launch(Dispatchers.Default) {
            viewModel.markTaskDone(task_id)
        }
        requireActivity().runOnUiThread {
            Toast.makeText(context, "Task Done", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDeleteTask(item_holder: Task) {
        MainScope().launch(Dispatchers.Default) {
            viewModel.deleteTask(item_holder)
        }
        requireActivity().runOnUiThread {
            Toast.makeText(context, "Task Deleted successfully", Toast.LENGTH_SHORT).show()
        }
    }
}