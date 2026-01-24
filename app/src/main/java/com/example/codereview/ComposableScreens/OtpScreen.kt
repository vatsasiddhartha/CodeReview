package com.example.codereview.ComposableScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun otpScreen(){
    var OTP by remember { mutableStateOf("") }
    Box(Modifier.fillMaxSize().background(Color(0x7CA7DBAA)),
        contentAlignment = Alignment.Center
    ){
        Column(modifier = Modifier.fillMaxWidth().padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(
                text = "Welcome Back",
                fontSize = 28.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {  },
                shape = RoundedCornerShape(20.dp),

                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp).background(Color(0x7CA7DBAA))
            ) {
                Text(text = "SUBMIT", fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Signup Text Button
            Text(
                text = "Resend Link ",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable {  }
            )
        }
    }

}