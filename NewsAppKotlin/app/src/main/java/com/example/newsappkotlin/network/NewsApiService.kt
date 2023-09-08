package com.example.newsappkotlin.network

import androidx.lifecycle.MutableLiveData
import retrofit2.Converter
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "78fd574531244c6d8727f86b2062db55"
private const val BASE_URL = "https://newsapi.org/"
var URL: String = "https://www.google.com" // default url

//https://newsapi.org/v2/everything?q=bitcoin&apiKey=78fd574531244c6d8727f86b2062db55


fun getRetrofitInstance(isGSONConvertor: Boolean, url: String): Retrofit {
    var convertor: Any = ScalarsConverterFactory.create()
    if (isGSONConvertor) {
        convertor = GsonConverterFactory.create()
    }

    return Retrofit.Builder().baseUrl(url).addConverterFactory(convertor as Converter.Factory)
        .build()
}

interface NewsService {

    @GET("v2/everything")
    suspend fun getNews(
        @Query("q") q: String, @Query("apiKey") apiKey: String = API_KEY
    ): Response<ArticlesJSON>
}

object NewsApiService {
    val service: NewsService = getRetrofitInstance(true, BASE_URL).create(NewsService::class.java)
}


interface NewsArticleEndPoint {
    @GET("/")
    suspend fun getArticle(): String
}


object NewsArticleService {
    fun setAndGetURL(url: MutableLiveData<String>): NewsArticleEndPoint {
        URL = url.value!!

        if (URL.substring(URL.length - 1) != "/") URL += "/"

        return getRetrofitInstance(false, URL).create(NewsArticleEndPoint::class.java)

    }
}