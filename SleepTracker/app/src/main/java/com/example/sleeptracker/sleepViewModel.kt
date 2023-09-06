package com.example.sleeptracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.sleeptracker.Database.SleepDatabaseDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext

class sleepViewModel(private val database: SleepDatabaseDAO, application: Application) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private val uiScope = CoroutineScope(Dispatchers.Main +  viewModelJob)

    private val nights = database.getAllSleepData()

    suspend fun insertSleep(sleep: SleepHolder){
        database.insert(sleep)
    }

    suspend fun clear(){
        database.clear()
    }


}