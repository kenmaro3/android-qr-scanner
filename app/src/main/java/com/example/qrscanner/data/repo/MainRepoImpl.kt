package com.example.qrscanner.data.repo

import com.example.qrscanner.domain.repo.MainRepo
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScanner
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainRepoImpl @Inject constructor(
    private val scanner: GmsBarcodeScanner
): MainRepo {

    override fun startScanning(): Flow<String?> {
        return callbackFlow {
            scanner.startScan()
                .addOnSuccessListener { barcode ->
                    launch {
                        send(getDetails(barcode))
                    }
                }
                .addOnFailureListener {
                    it.printStackTrace()
                }

            awaitClose{}
        }
    }

    private fun getDetails(barcode: Barcode): String{
        return when(barcode.valueType){
            Barcode.TYPE_URL -> {
                "url: ${barcode.url!!.url}"
            }
            else -> {
                barcode.rawValue ?: "only url is accepted"
            }
        }
    }

}