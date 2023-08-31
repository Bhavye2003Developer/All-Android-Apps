package com.example.reviseconcepts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.submit).setOnClickListener {
            Toast.makeText(this, "Submitting...", Toast.LENGTH_SHORT).show()
            var result = "The sum is : ${findViewById<EditText>(R.id.num1).editableText.toString().toInt()+findViewById<EditText>(R.id.num2).editableText.toString().toInt()}\n"
            result += "Your name is : ${findViewById<EditText>(R.id.username).editableText}"
            findViewById<TextView>(R.id.result).text = result
        }
    }
}