package com.example.twoscreenapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button : Button = findViewById(R.id.button)

        val editText : EditText = findViewById(R.id.editTextTextPersonName);

        button.setOnClickListener {
            Toast.makeText(this,"Sending...",Toast.LENGTH_SHORT).show();  //Black transparent box in bottom

            val text = editText.editableText.toString(); // Get text from editText that user entered

            val intent : Intent = Intent(this,Second_activity::class.java);

            // this -> current kotlin class
            // :: -> for class reference

            intent.putExtra("send_data",text); // sending data of edittext from this MainActivity to second_activity

            startActivity(intent); // To start particular activity
        }
    }
}