package com.example.twoscreenapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Second_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent : Intent = getIntent(); //get That intent to get extraString that passed from MainActivity to this activity
        val text = intent.getStringExtra("send_data"); // To get that extraString

        val textView : TextView = findViewById(R.id.textView2)
        textView.text = "Hello $text,\nMy name is Bhavye, This is my first app for a intent activity..." // Updates the textView after we get StringExtra
    }
}