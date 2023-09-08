package com.example.marsphotos

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.marsphotos.network.MarsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MarsDataViewModel(application: Application) : AndroidViewModel(application) {

    private val _status: MutableLiveData<String> = MutableLiveData()

    val status: LiveData<String>
        get() = _status

    fun getMarsPhotos() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val resultList = MarsApi.retrofitService.getPhotos()
                _status.postValue(resultList.toString())
            } catch (e: Exception) {
                _status.postValue("Error getting data from internet")
            }
        }
    }
}