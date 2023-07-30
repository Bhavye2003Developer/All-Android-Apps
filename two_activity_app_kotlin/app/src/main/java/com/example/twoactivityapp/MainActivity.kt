package com.example.twoactivityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name : EditText = findViewById(R.id.editTextTextPersonName)

        val button : Button = findViewById(R.id.button)
        button.setOnClickListener {
            val intent : Intent = Intent(this,second_activity::class.java)
            intent.putExtra(second_activity.key,name.editableText.toString())
            startActivity(intent)
        }
    }
}