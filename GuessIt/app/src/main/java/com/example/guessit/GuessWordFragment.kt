package com.example.guessit

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

class GuessWordFragment : Fragment(R.layout.guess_word_fragment) {

    private lateinit var word: TextView
    private lateinit var countWord: TextView
    private lateinit var gameViewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("view_model", "ViewModeProviders.of")
        gameViewModel = ViewModelProviders.of(this)[GameViewModel::class.java]

        word = view.findViewById(R.id.word)
        countWord = view.findViewById(R.id.countWord)

        view.findViewById<Button>(R.id.got_it).setOnClickListener {
            updateUI(isIncrementScore = true)
        }
        view.findViewById<Button>(R.id.skip).setOnClickListener {
            updateUI(isIncrementScore = false)
        }
    }


    private fun updateUI(isIncrementScore: Boolean) {

        if (isIncrementScore) {
            (countWord.text.toString().toInt() + 1).toString().also { countWord.text = it }
        } else {
            (countWord.text.toString().toInt() - 1).toString().also { countWord.text = it }
        }
        val newWord = gameViewModel.words.getNextWord()
        if (newWord == "finished") {

            val bundle = bundleOf("score" to countWord.text.toString())
            findNavController().navigate(
                R.id.action_guessWordFragment2_to_gameFinishedFragment, bundle
            )
        } else {
            word.text = gameViewModel.words.getNextWord()
        }
    }
}