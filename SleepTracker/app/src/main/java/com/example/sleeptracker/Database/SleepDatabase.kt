package com.example.sleeptracker.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sleeptracker.SleepHolder

@Database(entities = [SleepHolder::class], version = 1, exportSchema = false)
abstract class SleepDatabase : RoomDatabase() {

    abstract val sleepDatabaseDAO: SleepDatabaseDAO

    companion object {
        @Volatile
        private var INSTANCE: SleepDatabase? = null

        fun getInstance(context: Context) : SleepDatabase {
            synchronized(this){
                if (INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        SleepDatabase::class.java,
                        "sleep_database"
                    ).fallbackToDestructiveMigration()
                        .build()
                }

                return INSTANCE!!
            }
        }
    }

}