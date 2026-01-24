package com.example.codereview.ComposableScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
@Composable
fun LoginScreen(
    navController: NavController
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0B1220)) // Deep coderun dark
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Welcome to ToodlesCode",
                fontSize = 28.sp,
                color = Color(0xFFE5E7EB),
                modifier = Modifier.padding(bottom = 40.dp)
            )

            // EMAIL
            TextField(
                value = email,
                onValueChange = { email = it },
                placeholder = {
                    Text("Email", color = Color(0xFF94A3B8))
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFF111827),
                    unfocusedContainerColor = Color(0xFF0F172A),
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color(0xFF38BDF8)
                )
            )

            Spacer(modifier = Modifier.height(18.dp))

            // PASSWORD
            TextField(
                value = password,
                onValueChange = { password = it },
                placeholder = {
                    Text("Password", color = Color(0xFF94A3B8))
                },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFF111827),
                    unfocusedContainerColor = Color(0xFF0F172A),
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color(0xFF38BDF8)
                )
            )

            Spacer(modifier = Modifier.height(32.dp))

            // LOGIN BUTTON
            Button(
                onClick = {
                    navController.navigate("Main") {
                        popUpTo("Login") { inclusive = true }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF38BDF8)
                )
            ) {
                Text(
                    text = "Login",
                    fontSize = 18.sp,
                    color = Color(0xFF020617)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Don’t have an account? Sign up",
                color = Color(0xFF38BDF8),
                fontSize = 14.sp,
                modifier = Modifier.clickable {
                    navController.navigate("signup")
                }
            )
        }
    }
}

