package com.example.newsappkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.newsappkotlin.databinding.ArticleReadFragmentBinding
import com.example.newsappkotlin.newsViewModel.ArticleViewModel

class ArticleReadFragment : Fragment(R.layout.article_read_fragment) {

    private lateinit var binding: ArticleReadFragmentBinding
    private lateinit var viewModel: ArticleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = ArticleReadFragmentBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[ArticleViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = arguments?.getString("article_url")
        viewModel.setUrl(url!!)

        binding.progressBar2.visibility = View.VISIBLE
        binding.articleScrollView.visibility = View.GONE

        viewModel.article.observe(viewLifecycleOwner) {
            binding.progressBar2.visibility = View.GONE
            binding.article.text = it
            binding.articleScrollView.visibility = View.VISIBLE
        }
        viewModel.getArticle()
    }
}