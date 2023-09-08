package com.example.newsappkotlin.network

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val API_KEY = "78fd574531244c6d8727f86b2062db55"
private const val BASE_URL = "https://newsapi.org/"


//https://newsapi.org/v2/everything?q=bitcoin&apiKey=78fd574531244c6d8727f86b2062db55


private var retrofit: Retrofit =
    Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
        .build()

interface NewsService {

    @GET("v2/everything")
    suspend fun getNews(@Query("q") q: String, @Query("apiKey") apiKey: String = API_KEY): Response<ArticlesJSON>
}

object NewsApiService {
    val service: NewsService = retrofit.create(NewsService::class.java)
}