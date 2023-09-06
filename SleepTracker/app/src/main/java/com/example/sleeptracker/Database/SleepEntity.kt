package com.example.sleeptracker.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Duration
import java.time.LocalDateTime


@Entity(tableName = "daily_sleep_quality_table")
data class SleepEntity(
    @PrimaryKey(autoGenerate = true) var sleepId: Long = 0L,
    @ColumnInfo(name = "start_time") var startTime: LocalDateTime,
    @ColumnInfo(name = "end_time") var endTime: LocalDateTime,
    @ColumnInfo(name = "duration") var duration: Duration,
    @ColumnInfo(name = "sleep_quality") var sleepQuality: String,
)
