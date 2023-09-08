package com.example.newsappkotlin.newsViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappkotlin.network.Article
import com.example.newsappkotlin.network.NewsApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val _newsFromQuery: MutableLiveData<List<Article>> = MutableLiveData()
    val newsFromQuery: LiveData<List<Article>>
        get() = _newsFromQuery

    fun getNewsFromQuery(newsQuery: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = NewsApiService.service.getNews(q = newsQuery)

            if (response.isSuccessful) {
                val news = response.body()?.articles
                try {
                    _newsFromQuery.postValue(news)
                } catch (e: Exception) {
                    Log.d("Investigate", e.toString())
                }
            }
        }
    }
}