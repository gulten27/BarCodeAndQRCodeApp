package com.gultendogan.barcodeandqrcodeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gultendogan.barcodeandqrcodeapp.barcode.BarcodeActivity
import com.gultendogan.barcodeandqrcodeapp.databinding.ActivityMainBinding
import com.gultendogan.barcodeandqrcodeapp.qr.QrActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.barcodeButton.setOnClickListener {
            val intent = Intent(this, BarcodeActivity::class.java)
            startActivity(intent)
        }

        binding.qrcodeButton.setOnClickListener {
            val intent = Intent(this, QrActivity::class.java)
            startActivity(intent)
        }

    }
}