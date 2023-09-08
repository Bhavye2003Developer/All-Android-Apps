package com.example.newsappkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsappkotlin.databinding.NewsArticlesFragmentBinding
import com.example.newsappkotlin.network.Article
import com.example.newsappkotlin.newsRecyclerView.NewsAdapter
import com.example.newsappkotlin.newsViewModel.NewsViewModel

class NewsArticlesFragment : Fragment(R.layout.news_articles_fragment) {

    private lateinit var binding: NewsArticlesFragmentBinding
    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = NewsArticlesFragmentBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this)[NewsViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.newsRecyclerView.setHasFixedSize(true)
        binding.newsRecyclerView.layoutManager = LinearLayoutManager(context)


        binding.btnSearchNews.setOnClickListener {
            val newsQuery = binding.query.editableText.toString()
            viewModel.getNewsFromQuery(newsQuery)
            binding.newsRecyclerView.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
        }

        // observer the data
        viewModel.newsFromQuery.observe(viewLifecycleOwner) {
            binding.newsRecyclerView.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
            binding.newsRecyclerView.adapter = NewsAdapter(it) {
                onArticleClick(it)
            }  // NewsAdapter
        }
    }

    private fun onArticleClick(article: Article) {
        val bundle = bundleOf("article_url" to article.url)
        findNavController().navigate(
            R.id.action_newsArticlesFragment_to_articleReadFragment, bundle
        )
    }
}