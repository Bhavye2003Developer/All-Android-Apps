package com.example.dshare.shareFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.dshare.R
import com.example.dshare.databinding.HomeFragmentBinding

class Home : Fragment(R.layout.home_fragment) {

    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSender.setOnClickListener {
            val action = HomeDirections.actionHome2ToSender()
            findNavController().navigate(action)
        }

        binding.btnReceiver.setOnClickListener {
            val action = HomeDirections.actionHome2ToReceiver()
            findNavController().navigate(action)
        }
    }
}