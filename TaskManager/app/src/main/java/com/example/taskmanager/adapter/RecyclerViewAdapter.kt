package com.example.taskmanager.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanager.OnItemClickListener
import com.example.taskmanager.R
import com.example.taskmanager.task_room.Task
import java.text.SimpleDateFormat
import java.util.*


class RecyclerViewAdapter(
    private var tasks_list: List<Task>, private val clickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val taskTitle: TextView = view.findViewById(R.id.textViewTaskTitle)
        val startDate: TextView = view.findViewById(R.id.textViewStartDate)
        val deadline: TextView = view.findViewById(R.id.textViewDeadline)
        val done: ImageView = view.findViewById(R.id.imageViewRightTick)
        val delete: ImageView = view.findViewById(R.id.imageViewWrongTick)
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
        holder.taskTitle.text = "Task -: ${item.task}"
        holder.startDate.text = "Started from -: ${convertLongToTime(item.start_date)}"
        holder.deadline.text = "Deadline -: ${convertLongToTime(item.end_date)}"

        if (tasks_list[position].isDone == 1) {
            holder.taskTitle.paintFlags = holder.taskTitle.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }

        holder.done.setOnClickListener {
//            Toast.makeText(context, holder.taskTitle.text, Toast.LENGTH_SHORT).show()
            clickListener.onDoneTask(tasks_list[position].id)
        }

        holder.delete.setOnClickListener {
            clickListener.onDeleteTask(tasks_list[position])
        }
    }

    fun updateTasks(newTasks: List<Task>) {
        tasks_list = newTasks
        notifyDataSetChanged()
    }

    private fun convertLongToTime(time: Long): String {
        val date = Date(time)
        val sdf = SimpleDateFormat("EEE MMM dd yyyy", Locale.getDefault())
        return sdf.format(date)
    }
}