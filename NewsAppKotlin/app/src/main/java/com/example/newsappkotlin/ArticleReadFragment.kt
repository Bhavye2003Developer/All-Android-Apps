package com.example.newsappkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newsappkotlin.databinding.ArticleReadFragmentBinding

class ArticleReadFragment : Fragment(R.layout.article_read_fragment) {

    private lateinit var binding: ArticleReadFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = ArticleReadFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = arguments?.getString("article_url")
        binding.article.text = url
    }
}