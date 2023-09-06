package com.example.sleeptracker.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.sleeptracker.SleepHolder

@Dao
interface SleepDatabaseDAO {

    @Insert
    fun insert(sleepNight:SleepHolder)

    @Query("DELETE FROM daily_sleep_quality_table")
    fun clear()

    @Query("SELECT * FROM daily_sleep_quality_table ORDER BY end_time DESC")
    fun getAllSleepData() : LiveData<List<SleepHolder>>
}