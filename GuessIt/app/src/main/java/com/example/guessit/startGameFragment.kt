package com.example.guessit

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class startGameFragment : Fragment(R.layout.start_game_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.playGame).setOnClickListener {
//            findNavController().navigate(R.id.action_startGameFragment_to_guessWordFragment2)
            val action = startGameFragmentDirections.actionStartGameFragmentToGuessWordFragment2()
            findNavController().navigate(action)
        }

    }
}