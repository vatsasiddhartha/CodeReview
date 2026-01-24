package com.example.codereview.ComposableScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IntroScreen()
{
    Box(Modifier
        .fillMaxSize()
        .background(Color(0x7CA7DBAA)), contentAlignment = Alignment.Center){



        Column (modifier = Modifier.fillMaxWidth().padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally){

               Text(text="", fontSize = 28.sp,
                   color = Color.Black)



            Spacer(modifier = Modifier.height(28.dp))
            Button(
                onClick = {  },
                shape = RoundedCornerShape(20.dp),

                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp).background(Color(0x7CA7DBAA))
            ) {
                Text(text = "SUBMIT", fontSize = 16.sp)
            }






















            




        }



    }
}