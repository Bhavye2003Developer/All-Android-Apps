package com.example.learncoroutine

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val TAG = "THREADS-LEARN"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun increment(view: View) {
        findViewById<TextView>(R.id.count).text =
            (findViewById<TextView>(R.id.count).text.toString().toInt()+1).toString()
        Log.d(TAG, "increment -> ${Thread.currentThread().name}")
    }
    private fun doWork(){
//        delay(1000)
        for (i in 1..1000000000L){
            if (i==1000000000L){
                Log.d(TAG, "For loop completed and thread : ${Thread.currentThread().name}")
            }
        }
    }
    fun executeLongTask(view: View) {
//        thread {
//            Log.d(TAG, "executeLongTask -> ${Thread.currentThread().name}")
//            doWork()
//        }

//        MainScope().launch(Dispatchers.Default) {
//            Log.d(TAG, "executeLongTask -> ${Thread.currentThread().name}")
//            doWork()
//        }
//        MainScope().launch(Dispatchers.IO) {
//            Log.d(TAG, "executeLongTask -> ${Thread.currentThread().name}")
//            doWork()
//        }

        MainScope().launch (Dispatchers.Main){
            doWork()
            Log.d(TAG, "executeLongTask -> ${Thread.currentThread().name}")
        }

        MainScope().launch(Dispatchers.Main){
            Log.d(TAG, "anotherTask -> ${Thread.currentThread().name}")
        }

    }
}