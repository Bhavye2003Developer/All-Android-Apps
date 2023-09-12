package com.example.diffusion

data class ImageResponse(
    val generationTime: Double,
    val id: Int,
    val meta: Meta,
    val output: List<String>,
    val status: String
)