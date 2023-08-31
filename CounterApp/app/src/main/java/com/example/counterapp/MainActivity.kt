package com.example.counterapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.counterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val SAVED_COUNT = "MainActivity_saved_count"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Toast.makeText(this, "onCreate() called", Toast.LENGTH_SHORT).show()

        if (savedInstanceState != null) {
            // Restore value of members from saved state
            val prevCount = savedInstanceState.getString(SAVED_COUNT);
            binding.count.text = prevCount.toString()
        } else {
            // Probably initialize members with default values for a new instance
            binding.count.text = "0"
        }

        findViewById<Button>(R.id.add).setOnClickListener {
            val count: Int = binding.count.text.toString().toInt()
            binding.count.text = (count + 1).toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        val cnt = binding.count.text
        outState.putString(SAVED_COUNT, cnt.toString())
        Toast.makeText(this, "onSaveInstanceState called", Toast.LENGTH_SHORT).show()
        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "onStart() called", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "onRestart() called", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause() called", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop() called", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume() called", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy() called", Toast.LENGTH_SHORT).show()
    }

}