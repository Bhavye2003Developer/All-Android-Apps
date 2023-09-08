package com.example.newsappkotlin.newsViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappkotlin.network.NewsArticleService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class ArticleViewModel : ViewModel() {

    private val _article: MutableLiveData<String> = MutableLiveData()
    val article: LiveData<String>
        get() = _article

    private val _url: MutableLiveData<String> = MutableLiveData()

    fun setUrl(url: String) {
        _url.value = url
    }

    fun getArticle() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val newsObj = NewsArticleService
                val news = newsObj.setAndGetURL(_url).getArticle()
                val doc: Document = Jsoup.parse(news)
                // Extract all the text content from the parsed HTML document
                val newsString: String = doc.text()

                _article.postValue(newsString)
            } catch (e: Exception) {
                _article.postValue(e.toString())
            }
        }
    }

}