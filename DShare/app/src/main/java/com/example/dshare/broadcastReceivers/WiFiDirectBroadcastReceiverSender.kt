package com.example.dshare.broadcastReceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.p2p.WifiP2pDeviceList
import android.net.wifi.p2p.WifiP2pManager
import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * A BroadcastReceiver that notifies of important Wi-Fi p2p events.
 */
class WiFiDirectBroadcastReceiverSender(
    private val manager: WifiP2pManager,
    private val channel: WifiP2pManager.Channel,
    private val fragment: Fragment,
    private val peersList: (WifiP2pDeviceList) -> Unit
) : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION -> {
                // Check to see if Wi-Fi is enabled and notify appropriate activity
                when (intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1)) {
                    WifiP2pManager.WIFI_P2P_STATE_ENABLED -> {
                        // Wifi P2P is enabled
                        Toast.makeText(context, "Wifi P2P is enabled", Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        // Wi-Fi P2P is not enabled
                        Toast.makeText(context, "Wifi P2P is not enabled", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

                // Discovering peers(Devices) to connect
                manager.discoverPeers(channel, object : WifiP2pManager.ActionListener {
                    override fun onSuccess() {
                        Toast.makeText(context, "Discover Process Completed", Toast.LENGTH_SHORT).show()
                    }

                    override fun onFailure(reasonCode: Int) {
                        Toast.makeText(context, "Discover Process Failed!!!", Toast.LENGTH_SHORT).show()
                    }
                })
            }

            // If peer discovery is successful
            WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION -> {
                // Call WifiP2pManager.requestPeers() to get a list of current peers
                manager.requestPeers(channel) {
                    // Handle peers list
                    WifiP2pManager.PeerListListener {
                        peersList(it)
                    }.onPeersAvailable(it)
                }
            }
            WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION -> {
                // Respond to new connection or disconnections
            }
        }
    }


}