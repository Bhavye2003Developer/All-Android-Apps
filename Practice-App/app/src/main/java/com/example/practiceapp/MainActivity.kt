package com.example.practiceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.practiceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            binding.output.text = "By ${binding.name.editableText.toString()}"
            binding.output.visibility = View.VISIBLE
            binding.name.visibility = View.INVISIBLE
            binding.button.visibility = View.INVISIBLE
            binding.scrollable.visibility = View.VISIBLE
            Toast.makeText(this,"Edited Successfully...",Toast.LENGTH_SHORT).show()
        }
    }
}