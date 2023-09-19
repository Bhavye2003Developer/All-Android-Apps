package com.example.dshare.shareFragments

import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import android.net.wifi.p2p.WifiP2pDevice
import android.net.wifi.p2p.WifiP2pDeviceList
import android.net.wifi.p2p.WifiP2pManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.RECEIVER_EXPORTED
import androidx.core.content.ContextCompat.registerReceiver
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dshare.R
import com.example.dshare.WifiItemAdapter
import com.example.dshare.broadcastReceivers.WiFiDirectBroadcastReceiverSender
import com.example.dshare.databinding.SenderFragmentBinding

class Sender : Fragment(R.layout.sender_fragment) {

    private lateinit var binding: SenderFragmentBinding
    private lateinit var intentFilter: IntentFilter

    private val manager: WifiP2pManager? by lazy(LazyThreadSafetyMode.NONE) {
        context?.getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager?
    }

    private var channel: WifiP2pManager.Channel? = null
    private var receiver: BroadcastReceiver? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = SenderFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        Toast.makeText(context, "Fragment created", Toast.LENGTH_SHORT).show()

        channel = manager?.initialize(context, context?.mainLooper, null)
        channel?.also { channel ->
            receiver = manager?.let {
                WiFiDirectBroadcastReceiverSender(
                    it, channel, this, ::peersList
                )
            }
        }
        intentFilter = IntentFilter().apply {
            addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION)
            addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION)
            addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION)
            addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION)
        }

        binding.recyclerViewListPeers.layoutManager = LinearLayoutManager(context)

    }

    override fun onResume() {
        super.onResume()
        receiver?.also { receiver ->
            context?.let { registerReceiver(it, receiver, intentFilter, RECEIVER_EXPORTED) }
        }
    }

    override fun onPause() {
        super.onPause()
        receiver?.also { receiver ->
            context?.unregisterReceiver(receiver)
        }
    }


    private fun peersList(wifiP2pDeviceList: WifiP2pDeviceList) {

        if (wifiP2pDeviceList.deviceList.isEmpty()) {
            Toast.makeText(context, "No Devices Available", Toast.LENGTH_SHORT).show()
        } else {
            binding.recyclerViewListPeers.adapter = WifiItemAdapter(wifiP2pDeviceList, ::connectToDevice)
            binding.recyclerViewListPeers.setHasFixedSize(true)
        }
    }

    private fun connectToDevice(device: WifiP2pDevice){
        Toast.makeText(context, "You are connecting to ${device.deviceName}...", Toast.LENGTH_SHORT).show()
    }

}