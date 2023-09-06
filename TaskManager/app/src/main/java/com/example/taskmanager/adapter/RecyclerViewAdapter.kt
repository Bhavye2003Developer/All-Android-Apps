package com.example.taskmanager.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanager.R
import com.example.taskmanager.task_room.Task


class RecyclerViewAdapter(private val context: Context, private var tasks_list: List<Task>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {


    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val taskTitle: TextView = view.findViewById(R.id.textViewTaskTitle)
        val startDate: TextView = view.findViewById(R.id.textViewStartDate)
        val deadline: TextView = view.findViewById(R.id.textViewDeadline)
    }

    override fun getItemCount(): Int {
        return tasks_list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // creating new view
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = tasks_list[position]
        holder.taskTitle.text = item.task
        holder.startDate.text = item.start_date.toString()
        holder.deadline.text = item.end_date.toString()
    }

    fun updateTasks(newTasks: List<Task>) {
        tasks_list = newTasks
        notifyDataSetChanged()
    }
}