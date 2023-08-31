package com.example.sleeptracker

data class SleepHolder(
    var startTime: String,
    var endTime: String,
    var sleepQuality: String,
    var hrs: String
){
    fun getSleepRecord(): String {
        return "Start: $startTime\nEnd: $endTime\nQuality: $sleepQuality\nHours:Minutes:Seconds $hrs"
    }
}