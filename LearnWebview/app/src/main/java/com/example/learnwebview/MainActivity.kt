package com.example.learnwebview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Display
import android.view.WindowManager
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val show = findViewById<Button>(R.id.show)
        val userUrl = findViewById<EditText>(R.id.userURL)

        var text : String ?= null

        show.setOnClickListener {
            text = userUrl.editableText.toString()

            if (text.isNullOrBlank())
                text = "google.com"
            Toast.makeText(applicationContext, "You are redirecting to $text...", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext, ShowWebpage::class.java)
            intent.putExtra("urlText", text)
            startActivity(intent)
        }
    }
}