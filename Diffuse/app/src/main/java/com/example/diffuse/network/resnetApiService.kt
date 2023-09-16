package com.example.diffuse.network

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


const val BASE_URL = "https://api-inference.huggingface.co/models/"


var retrofit: Retrofit =
    Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
        .addConverterFactory(ScalarsConverterFactory.create()).build()

interface ClassifyImageService {
    @Headers("Authorization: Bearer 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")
    @POST("microsoft/resnet-50")
    fun classifyImage(@Body body: RequestBody): Call<String>
}


object ResnetApiService {
    val service = retrofit.create(ClassifyImageService::class.java)
}