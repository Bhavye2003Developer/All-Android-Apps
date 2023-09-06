package com.example.nameviewerapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.nameviewerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: NameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        viewModel = ViewModelProvider(this)[NameViewModel::class.java]

        binding.add.setOnClickListener {
            viewModel.addNote(binding.note.editableText.toString())
            binding.note.editableText.clear()
        }

//        val notesObserver = Observer<String> {
//            binding.allNotes.text = viewModel.allNotes.value
//        }
//
//        viewModel.allNotes.observe(this, notesObserver)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}