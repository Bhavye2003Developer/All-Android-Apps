package com.example.tracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val locations: MutableList<LocationItem>) :
    RecyclerView.Adapter<RecyclerAdapter.LocationViewHolder>() {

    class LocationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val latitude: TextView = view.findViewById(R.id.latitude)
        val longitude: TextView = view.findViewById(R.id.longitude)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.location_item, parent, false)
        return LocationViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return locations.size
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val location = locations[position]
        holder.latitude.text = "Lat  : ${location.latitude}"
        holder.longitude.text = "Long : ${location.longitude}"
    }
}