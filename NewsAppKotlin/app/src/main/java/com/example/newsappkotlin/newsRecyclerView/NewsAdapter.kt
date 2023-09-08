package com.example.newsappkotlin.newsRecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsappkotlin.R
import com.example.newsappkotlin.network.Article

class NewsAdapter(private val articles: List<Article>, private val onArticleClick: (Article) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.textViewTitle)
        val author: TextView = view.findViewById(R.id.textViewAuthor)
        val publishedAt: TextView = view.findViewById(R.id.textViewPublishedAt)
        val url: TextView = view.findViewById(R.id.textViewURL)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.article_view_item, parent, false)
        adapterLayout.setOnClickListener {}
        return NewsViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = articles[position]
        holder.title.text = article.title
        holder.author.text = article.author
        holder.publishedAt.text = article.publishedAt
        holder.url.text = article.url

        holder.itemView.setOnClickListener {
            onArticleClick(article)
        }
    }
}