package com.example.tracker

import android.Manifest
import android.annotation.SuppressLint
import android.app.Application
import android.content.pm.PackageManager
import android.location.Location
import android.os.Looper
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.location.*

class LocationViewModel(application: Application) : AndroidViewModel(application) {

    private val _liveAllLocations: MutableLiveData<MutableList<LocationItem>> = MutableLiveData(
        mutableListOf()
    )
    val liveAllLocations: LiveData<MutableList<LocationItem>>
        get() = _liveAllLocations

    private val fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(application.applicationContext)

    private lateinit var mCurrentLocation: Location

    init {
        if (ActivityCompat.checkSelfPermission(
                application.applicationContext, Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                application.applicationContext, Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Log.d("LocateError", "Error : Location permission not granted")
        }
        fusedLocationClient.lastLocation.addOnSuccessListener {
            mCurrentLocation = it
        }
    }

    @SuppressLint("MissingPermission")
    fun startLocationUpdates() {
        fusedLocationClient.requestLocationUpdates(
            createLocationRequest(), object : LocationCallback() {
                override fun onLocationResult(locationResult: LocationResult) {
                    // Update UI with location data
                    val newLocation = LocationItem(
                        locationResult.lastLocation?.latitude.toString(),
                        locationResult.lastLocation?.longitude.toString()
                    )

                    val listLocations = _liveAllLocations.value!!
                    listLocations.add(newLocation)
                    _liveAllLocations.postValue(listLocations)
                    Log.d("newlocate", _liveAllLocations.value.toString())
                }
            }, Looper.getMainLooper()
        )
    }

    private fun createLocationRequest(): LocationRequest {
        val locationRequest = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 5000).apply {
            setWaitForAccurateLocation(false)
            setMinUpdateIntervalMillis(LocationRequest.Builder.IMPLICIT_MIN_UPDATE_INTERVAL)
            setMaxUpdateDelayMillis(6000)
        }.build()
        return locationRequest
    }

}