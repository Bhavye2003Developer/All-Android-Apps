package com.example.learnviewbinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.learnviewbinding.databinding.Frag1Binding

class frag1 : Fragment(R.layout.frag1) {

    private var _binding: Frag1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Frag1Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.frag1Layout.setOnClickListener {
            Toast.makeText(context, "Fragment1 clicked", Toast.LENGTH_SHORT).show()
        }
    }
}