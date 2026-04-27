package com.example.codereview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.codereview.ComposableScreens.CoderunScreen
import com.example.codereview.code.CodeViewModel

class MainActivity : ComponentActivity() {
   val viewmodel : CodeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            setContent {
                CoderunScreen(codeViewModel = viewmodel)
            }
        }
    }}

