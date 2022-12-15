package com.gultendogan.barcodeandqrcodeapp.qr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gultendogan.barcodeandqrcodeapp.R
import com.gultendogan.barcodeandqrcodeapp.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding : ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val url = intent.getStringExtra("url")
        binding.webview.loadUrl(url.toString())
    }
}