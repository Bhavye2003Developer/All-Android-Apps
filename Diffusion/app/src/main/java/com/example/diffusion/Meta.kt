package com.example.diffusion

data class Meta(
    val H: Int,
    val W: Int,
    val enable_attention_slicing: String,
    val file_prefix: String,
    val guidance_scale: Double,
    val model: String,
    val n_samples: Int,
    val negative_prompt: String,
    val outdir: String,
    val prompt: String,
    val revision: String,
    val safety_checker: String,
    val seed: Int,
    val steps: Int,
    val vae: String
)