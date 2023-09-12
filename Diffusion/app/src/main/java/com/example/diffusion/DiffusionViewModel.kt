package com.example.diffusion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call

class DiffusionViewModel : ViewModel() {

    private val _imageFromTextResponse: MutableLiveData<ImageResponse> = MutableLiveData()
    val imageFromTextResponse: LiveData<ImageResponse>
        get() = _imageFromTextResponse

    fun getImageFromText(prompt: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val responseImage = Text2Image.service.getImageFromText(ImageBody(prompt = prompt))
            _imageFromTextResponse.postValue(responseImage)
        }
    }
}