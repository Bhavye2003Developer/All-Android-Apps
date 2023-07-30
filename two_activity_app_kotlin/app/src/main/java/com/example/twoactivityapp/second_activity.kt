package com.example.twoactivityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class second_activity : AppCompatActivity() {

    companion object {
        val key  = "main_to_second"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val output : TextView = findViewById(R.id.output)
        output.setText(intent.getStringExtra(key))
    }
}