package com.example.qrscanner

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.material.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import com.example.qrscanner.presentation.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Surface(modifier = Modifier.fillMaxSize(),
                color = Color.White
            ){
                MainScreen()
            }

        }
    }
}