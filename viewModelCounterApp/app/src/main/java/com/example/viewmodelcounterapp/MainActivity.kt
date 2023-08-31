package com.example.viewmodelcounterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelcounterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(CounterViewModel::class.java)

        setText()

        binding.increment.setOnClickListener {
            updateUI()
        }
    }


    private fun updateUI(){
        viewModel.increment()
        setText()
    }

    private fun setText(){
        binding.count.text = viewModel.getCount().toString()
    }
}