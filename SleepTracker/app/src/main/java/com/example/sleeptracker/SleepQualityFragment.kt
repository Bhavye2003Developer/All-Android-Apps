package com.example.sleeptracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sleeptracker.databinding.SleepQualityFragmentBinding

class SleepQualityFragment : Fragment(R.layout.sleep_quality_fragment) {

    private lateinit var binding: SleepQualityFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = SleepQualityFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleButtons()
    }


    private fun handleButtons() {
        val buttonList = listOf(
            binding.sleep0, binding.sleep1, binding.sleep2,
            binding.sleep3, binding.sleep4, binding.sleep5
        )

        buttonList.forEach { button ->
            button.setOnClickListener {
                val quality = it.tag.toString()
                printWhichButton(quality)
            }
        }
    }

    private fun printWhichButton(quality: String) {
        sleepHolder.sleepQuality = quality
        findNavController().navigate(SleepQualityFragmentDirections.actionSleepQualityFragmentToHomeFragment())
    }
}