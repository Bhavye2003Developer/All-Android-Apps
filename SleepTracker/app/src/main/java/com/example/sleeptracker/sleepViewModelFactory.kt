package com.example.sleeptracker

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sleeptracker.Database.SleepDatabaseDAO

@Suppress("UNCHECKED_CAST")
class sleepViewModelFactory(
    private val dataSource: SleepDatabaseDAO,
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(sleepViewModel::class.java)){
            return sleepViewModel(dataSource, application) as T
        }
        return super.create(modelClass)
    }
}