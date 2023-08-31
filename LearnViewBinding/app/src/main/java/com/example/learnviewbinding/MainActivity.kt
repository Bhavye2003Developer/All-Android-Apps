package com.example.learnviewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.learnviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.fragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment1, frag1()).commit()
        }

        binding.fragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment2, frag2()).commit()
        }
    }
}