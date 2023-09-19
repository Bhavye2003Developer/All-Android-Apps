package com.example.dshare

import android.net.wifi.p2p.WifiP2pDevice
import android.net.wifi.p2p.WifiP2pDeviceList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WifiItemAdapter(
    private val wifiP2pDeviceList: WifiP2pDeviceList,
    private val connectToDevice: (device: WifiP2pDevice) -> Unit
) : RecyclerView.Adapter<WifiItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val device_name: TextView = view.findViewById(R.id.device_name)
        val device_address: TextView = view.findViewById(R.id.device_address)
        val device_item: LinearLayout = view.findViewById(R.id.device_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.peers_list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return wifiP2pDeviceList.deviceList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val device = wifiP2pDeviceList.deviceList.elementAt(position)
        holder.device_name.text = "Device name -> ${device.deviceName}"
        holder.device_address.text = "Device mac address -> ${device.deviceAddress}"

        holder.device_item.setOnClickListener {
            connectToDevice(device)
        }
    }
}