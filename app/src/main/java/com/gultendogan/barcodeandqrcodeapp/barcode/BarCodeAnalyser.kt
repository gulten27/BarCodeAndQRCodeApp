package com.gultendogan.barcodeandqrcodeapp.barcode

import android.annotation.SuppressLint
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.barcode.Barcode
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage

class BarCodeAnalyser (private val barcodeListener: BarcodeAnalyzerListener) :
    ImageAnalysis.Analyzer {

    private val options = BarcodeScannerOptions.Builder().setBarcodeFormats(
        Barcode.FORMAT_CODE_39,
        Barcode.FORMAT_CODE_93,
        Barcode.FORMAT_CODE_128,
        Barcode.FORMAT_CODABAR,
        Barcode.FORMAT_EAN_13,
        Barcode.FORMAT_EAN_8,
        Barcode.FORMAT_ITF,
        Barcode.FORMAT_UPC_A,
        Barcode.FORMAT_UPC_E
    ).build()

    private val scanner by lazy {
        BarcodeScanning. getClient(options)
    }

    @SuppressLint("UnsafeExperimentalUsageError", "UnsafeOptInUsageError")
    override fun analyze(imageProxy: ImageProxy) {
        val mediaImage = imageProxy.image
        if (mediaImage != null) {
            val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)

            scanner.process(image)
                .addOnSuccessListener { barcodes ->

                    if (barcodes.isEmpty().not()) {
                        barcodeListener(barcodes)
                    }


                }
                .addOnFailureListener {
                    it.printStackTrace()
                }
                .addOnCompleteListener {
                    imageProxy.close()
                }
        }
    }
}