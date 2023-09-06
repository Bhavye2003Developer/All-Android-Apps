package com.example.sleeptracker

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import kotlin.time.toKotlinDuration

class Timer {
    @RequiresApi(Build.VERSION_CODES.O)
    private val DateFormatter: DateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
    @RequiresApi(Build.VERSION_CODES.O)
    private val TimeFormatter: DateTimeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)

    private lateinit var startTime: LocalDateTime
    private lateinit var endTime: LocalDateTime
    private lateinit var finalDuration: Duration

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getCurrentDateTime(): LocalDateTime {
        return LocalDateTime.now()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun start() {
        startTime = getCurrentDateTime()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun end() {
        endTime = getCurrentDateTime()
        finalDuration = Duration.between(startTime, endTime)
    }
//
//    @RequiresApi(Build.VERSION_CODES.O)
//    fun getStartTime(): String {
//        return "${startTime.format(DateFormatter)} Time: ${startTime.format(TimeFormatter)}"
//    }
//
//    @RequiresApi(Build.VERSION_CODES.O)
//    fun getEndTime(): String {
//        return "${endTime.format(DateFormatter)} Time: ${endTime.format(TimeFormatter)}"
//    }
//
//    @RequiresApi(Build.VERSION_CODES.S)
//    fun getDuration(): String {
//        return "${finalDuration.toHours()}:${finalDuration.toMinutes()}:${finalDuration.toKotlinDuration().inWholeSeconds}"
//    }

    fun getStartTime(): LocalDateTime {
        return startTime
    }

    fun getEndTime(): LocalDateTime {
        return endTime
    }

    fun getDuration(): Duration {
        return finalDuration
    }
}