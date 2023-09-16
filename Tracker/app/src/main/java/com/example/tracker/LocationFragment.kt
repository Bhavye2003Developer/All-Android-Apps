package com.example.tracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tracker.databinding.LocationFragmentBinding

class LocationFragment : Fragment(R.layout.location_fragment) {

    private lateinit var binding: LocationFragmentBinding
    private lateinit var locationViewModel: LocationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = LocationFragmentBinding.inflate(inflater, container, false)
        locationViewModel = ViewModelProvider(this)[LocationViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(context, "Fragment created", Toast.LENGTH_SHORT).show()

        binding.locationRecyclerView.setHasFixedSize(true)

        val llm = LinearLayoutManager(requireContext())
        llm.orientation = LinearLayoutManager.VERTICAL
        binding.locationRecyclerView.layoutManager = llm

        locationViewModel.startLocationUpdates()

        val observer = Observer<MutableList<LocationItem>> {
            binding.locationRecyclerView.adapter = RecyclerAdapter(it)
        }
        locationViewModel.liveAllLocations.observe(viewLifecycleOwner, observer)
    }

}