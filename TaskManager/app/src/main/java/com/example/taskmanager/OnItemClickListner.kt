package com.example.taskmanager

import com.example.taskmanager.task_room.Task

interface OnItemClickListener {
    fun onDoneTask(task_id: Long)
    fun onDeleteTask(item_holder: Task)
}