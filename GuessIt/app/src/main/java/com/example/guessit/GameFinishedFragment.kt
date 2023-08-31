package com.example.guessit

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController

@Suppress("DEPRECATION")
class GameFinishedFragment : Fragment(R.layout.game_finished_fragment) {

    lateinit var score: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        score = arguments?.getString("score").toString()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.score).text = score

        view.findViewById<Button>(R.id.playAgain).setOnClickListener {
            findNavController().navigate(R.id.action_gameFinishedFragment_to_startGameFragment2)
        }
    }
}