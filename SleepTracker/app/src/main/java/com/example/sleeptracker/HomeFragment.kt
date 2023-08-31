package com.example.sleeptracker

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sleeptracker.databinding.HomeFragmentBinding
import java.util.*

val sleepHolder: SleepHolder = SleepHolder("", "", "", "")

class HomeFragment : Fragment(R.layout.home_fragment) {

    private lateinit var binding: HomeFragmentBinding
    private lateinit var timer: Timer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        timer = Timer()

        binding = HomeFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.stopTimer.isEnabled = false

        binding.startTimer.setOnClickListener {
            timer.start()
            sleepHolder.startTime = timer.getStartTime()
            binding.stopTimer.isEnabled = true
            binding.startTimer.isEnabled = false
        }

        binding.stopTimer.setOnClickListener {
            timer.end()
            sleepHolder.endTime = timer.getEndTime()
            sleepHolder.hrs = timer.getDuration()

            val action = HomeFragmentDirections.actionHomeFragmentToSleepQualityFragment()
            findNavController().navigate(action)
        }
    }
}