package com.example.learnwebview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView

class ShowWebpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_webpage)

        val intent = getIntent()

        var urlString : String = intent.getStringExtra("urlText").toString()

        val url : String = "https://www.$urlString"

        val webview = findViewById<WebView>(R.id.webview)
        webview.loadUrl(url)

        webview.settings.loadWithOverviewMode = true
        webview.settings.useWideViewPort = true
        webview.settings.defaultFontSize = 20
        webview.settings.javaScriptEnabled = true
    }
}