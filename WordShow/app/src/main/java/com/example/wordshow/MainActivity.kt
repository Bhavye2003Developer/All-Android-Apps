package com.example.wordshow

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val viewModel : WordViewModel = ViewModelProvider(this)[WordViewModel::class.java]

        val wordDao = WordDatabase.getDatabase(applicationContext).wordDao()
        val repository = WordRepository(wordDao)
        viewModel = ViewModelProvider(this, WordViewModelFactory(repository))[WordViewModel::class.java]


        findViewById<Button>(R.id.buttonSubmit).setOnClickListener {
            val wordToAdd = findViewById<EditText>(R.id.editTextWord).editableText.toString()
            viewModel.insertWord(Word(0, wordToAdd))
        }

        val observer = Observer<List<String>>{
            findViewById<TextView>(R.id.textViewResult).text = it.toString()
        }
//        wordDao.getWords().observe(this, observer)

        viewModel.allWords.observe(this, observer)
    }
}