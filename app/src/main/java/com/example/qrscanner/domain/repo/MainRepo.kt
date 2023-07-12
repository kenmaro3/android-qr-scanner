package com.example.qrscanner.domain.repo

import kotlinx.coroutines.flow.Flow

interface MainRepo {
    fun startScanning() : Flow<String?>
}