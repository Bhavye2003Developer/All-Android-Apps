package com.example.marsphotos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.marsphotos.databinding.MarsPhotosFragmentBinding


class MarsPhotosFragment : Fragment(R.layout.mars_photos_fragment) {

    private lateinit var binding: MarsPhotosFragmentBinding
    private lateinit var viewModel: MarsDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.mars_photos_fragment, container, false)
        viewModel = ViewModelProvider(this)[MarsDataViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGetData.setOnClickListener {
            binding.scrollview.visibility = View.GONE
            binding.progressBarCyclic.visibility = View.VISIBLE
            viewModel.getMarsPhotos()
        }

        viewModel.status.observe(viewLifecycleOwner) {
            binding.progressBarCyclic.visibility = View.GONE
            binding.scrollview.visibility = View.VISIBLE
            binding.dataToShow.text = it
        }
    }
}