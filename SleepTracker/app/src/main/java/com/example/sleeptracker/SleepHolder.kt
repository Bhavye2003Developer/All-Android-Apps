package com.example.sleeptracker

import java.time.Duration
import java.time.LocalDateTime

data class SleepHolder(
    var startTime: LocalDateTime?,
    var endTime: LocalDateTime?,
    var sleepQuality: String?,
    var hrs: Duration?
){
}