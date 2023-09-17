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
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlin.properties.Delegates

class LocationViewModel(application: Application) : AndroidViewModel(application) {

    private val _liveAllLocations: MutableLiveData<MutableList<LocationItem>> = MutableLiveData(
        mutableListOf()
    )
    val liveAllLocations: LiveData<MutableList<LocationItem>>
        get() = _liveAllLocations

    private val fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(application.applicationContext)

    private lateinit var mCurrentLocation: Location
    private var database = Firebase.database
    private var ref = database.reference

    private var locateID by Delegates.notNull<Int>()

    init {

        // firebase
        ref.child("Locations").get().addOnSuccessListener {
            locateID = if (it.value is List<*>) {
                (it.value as List<*>).size
            } else {
                0
            }
        }

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

        Log.d("Firebase", "Database -> $database")
    }

    @SuppressLint("MissingPermission")
    fun startLocationUpdates() {
        fusedLocationClient.requestLocationUpdates(
            createLocationRequest(), object : LocationCallback() {
                override fun onLocationResult(locationResult: LocationResult) {
                    // Update UI with location data
                    val newLocation = locationResult.lastLocation?.longitude?.let {
                        locationResult.lastLocation?.latitude?.let { it1 ->
                            LocationItem(
                                it1, it
                            )
                        }
                    }
                    if (newLocation != null) {
                        writeNewLocation(newLocation)
                    }

                    val listLocations = _liveAllLocations.value!!
                    if (newLocation != null) {
                        listLocations.add(newLocation)
                    }
                    _liveAllLocations.postValue(listLocations)
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

    fun writeNewLocation(locationItem: LocationItem) {
        ref.child("Locations").child(locateID.toString()).setValue(locationItem)
        ++locateID
    }

}