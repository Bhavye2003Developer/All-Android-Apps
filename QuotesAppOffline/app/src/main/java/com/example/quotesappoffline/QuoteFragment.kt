package com.example.quotesappoffline

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.quotesappoffline.databinding.QuoteFragmentBinding


class QuoteFragment : Fragment(R.layout.quote_fragment) {

    private lateinit var binding: QuoteFragmentBinding
    private lateinit var viewModel: QuoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.quote_fragment, container, false)
        viewModel = ViewModelProvider(this)[QuoteViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNewQuote.setOnClickListener {
            viewModel.newQuote()
        }

//        val quoteObserver = Observer<String> {
//            binding.quote.text = viewModel.currentQuote.value
//        }
//
//        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
//        viewModel.currentQuote.observe(viewLifecycleOwner, quoteObserver)

        binding.viewModel = viewModel
        binding.setLifecycleOwner { lifecycle }
    }
}