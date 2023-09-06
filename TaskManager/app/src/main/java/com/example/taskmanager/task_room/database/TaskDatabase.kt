package com.example.taskmanager.task_room.database

import android.content.Context
import androidx.room.*
import com.example.taskmanager.task_room.Converters
import com.example.taskmanager.task_room.Task
import com.example.taskmanager.task_room.TaskDao

@Database(entities = [Task::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {
        @Volatile
        private var INSTANCE: TaskDatabase? = null

        fun getInstance(context: Context): TaskDatabase {
            if (INSTANCE == null) {
                synchronized(TaskDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext, TaskDatabase::class.java, "task_database"
                    ).allowMainThreadQueries().build()
                }
            }
            return INSTANCE!!
        }
    }
}