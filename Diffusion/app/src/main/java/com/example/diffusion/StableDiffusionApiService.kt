package com.example.diffusion

import com.google.gson.annotations.SerializedName
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import java.util.concurrent.TimeUnit


const val BASE_URL = "https://stablediffusionapi.com/api/v3/"

const val API_KEY = "Vh9xnTAnytJX6u2jPyCtbyG7xU2fsrUvXtose4iNQFPbYMbUOZxYJ3wqpOYu"

var client: OkHttpClient =
    OkHttpClient.Builder().connectTimeout(100, TimeUnit.SECONDS).readTimeout(100, TimeUnit.SECONDS)
        .build()
var retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL).client(client)
    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(GsonConverterFactory.create()).build()

data class ImageBody(
    @SerializedName("key") val key: String = API_KEY,
    @SerializedName("prompt") val prompt: String = "",
    @SerializedName("negative_prompt") val negativePrompt: String = "((out of frame)), ((extra fingers)), mutated hands, ((poorly drawn hands)), ((poorly drawn face)), (((mutation))), (((deformed))), (((tiling))), ((naked)), ((tile)), ((fleshpile)), ((ugly)), (((abstract))), blurry, ((bad anatomy)), ((bad proportions)), ((extra limbs)), cloned face, (((skinny))), glitchy, ((extra breasts)), ((double torso)), ((extra arms)), ((extra hands)), ((mangled fingers)), ((missing breasts)), (missing lips), ((ugly face)), ((fat)), ((extra legs))",
    @SerializedName("width") val width: String = "512",
    @SerializedName("height") val height: String = "512",
    @SerializedName("samples") val samples: String = "1",
    @SerializedName("num_inference_steps") val numInferenceSteps: String = "20",
    @SerializedName("safety_checker") val safetyChecker: String = "no",
    @SerializedName("enhance_prompt") val enhancePrompt: String = "yes",
    @SerializedName("seed") val seed: String? = null,
    @SerializedName("guidance_scale") val guidanceScale: Double = 7.5,
    @SerializedName("webhook") val webhook: String? = null,
    @SerializedName("track_id") val trackId: String? = null
)


interface StableDiffusionApiService {
    @Headers("Content-Type: application/json")
    @POST("text2img")  // model name
    suspend fun getImageFromText(@Body data: ImageBody): ImageResponse
}


object Text2Image {
    val service = retrofit.create(StableDiffusionApiService::class.java)
}