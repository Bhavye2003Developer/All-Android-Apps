package com.example.recyclerviewlearn

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerviewlearn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this)[NoteViewModel::class.java]

        setContentView(binding.root)

        binding.recyclerViewNotes.setHasFixedSize(true)

        binding.buttonAddNote.setOnClickListener {
            val noteToAdd = binding.editTextNote.editableText.toString()

            viewModel.addNote(Note(noteToAdd))

            Toast.makeText(this, "Note Added Successfully", Toast.LENGTH_SHORT).show()
        }

        viewModel.noteList.observe(this) {
            binding.recyclerViewNotes.adapter = NoteAdapter(it)
        }
    }
}