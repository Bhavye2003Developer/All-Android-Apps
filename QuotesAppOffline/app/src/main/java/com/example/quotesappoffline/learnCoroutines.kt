package com.example.quotesappoffline

import kotlinx.coroutines.*

fun main() {
    println("This is main thread work : ${Thread.currentThread().name}")

    GlobalScope.launch {
        doWork()
        doWork()
        doWork()
    }

    println("End of work on : ${Thread.currentThread().name}")
    Thread.sleep(1500)
}



suspend fun doWork(){
    delay(3000)
    println("Thread working on : ${Thread.currentThread().name}")
    delay(2000)
    println("The is after 2 sec delay")
}