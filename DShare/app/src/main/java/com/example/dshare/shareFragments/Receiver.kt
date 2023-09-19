package com.example.dshare.shareFragments

import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import android.net.wifi.p2p.WifiP2pManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.dshare.R
import com.example.dshare.broadcastReceivers.WifiDirectBroadcastReceiverReceiver
import com.example.dshare.databinding.ReceiverFragmentBinding

class Receiver : Fragment(R.layout.receiver_fragment) {

    private lateinit var binding: ReceiverFragmentBinding
    private lateinit var intentFilter: IntentFilter

    private val manager: WifiP2pManager? by lazy(LazyThreadSafetyMode.NONE) {
        context?.getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager?
    }

    private var channel: WifiP2pManager.Channel? = null
    private var receiver: BroadcastReceiver? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = ReceiverFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        channel = manager?.initialize(context, context?.mainLooper, null)

        channel?.also { channel ->
            receiver = manager?.let { WifiDirectBroadcastReceiverReceiver(it, channel, this) }
        }

        intentFilter = IntentFilter().apply {
            addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION)
            addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION)
            addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION)
            addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION)
        }
    }

    override fun onResume() {
        super.onResume()
        receiver?.also { receiver ->
            context?.let {
                ContextCompat.registerReceiver(
                    it, receiver, intentFilter, ContextCompat.RECEIVER_EXPORTED
                )
            }
        }
    }

    override fun onPause() {
        super.onPause()
        receiver?.also { receiver ->
            context?.unregisterReceiver(receiver)
        }
    }
}