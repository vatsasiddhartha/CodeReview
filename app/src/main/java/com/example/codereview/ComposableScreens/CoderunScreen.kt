package com.example.codereview.ComposableScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import com.example.codereview.code.CodeViewModel

@Composable
fun CoderunScreen(codeViewModel: CodeViewModel) {

    val output by codeViewModel.output.collectAsState()
    val error by codeViewModel.error.collectAsState()

    val languages = listOf(
        "Kotlin", "Java", "Python", "C", "C++",
        "JavaScript", "Go", "Rust", "Swift", "PHP"
    )

    var selectedLanguage by remember { mutableStateOf("Python") }
    var codeText by remember { mutableStateOf("") }

    val editorScroll = rememberScrollState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2F6FB)),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item {
            Text(
                text = "Code Runner",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                items(languages) { lang ->
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(
                                if (lang == selectedLanguage)
                                    Color(0xFF4A90E2)
                                else
                                    Color(0xFFE6EEF8)
                            )
                            .clickable { selectedLanguage = lang }
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Text(
                            text = lang,
                            color = if (lang == selectedLanguage)
                                Color.White else Color.Black
                        )
                    }
                }
            }
        }

        item {
            Text("Editor ($selectedLanguage)")
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
                    .background(Color.Black, RoundedCornerShape(16.dp))
            ) {
                BasicTextField(
                    value = codeText,
                    onValueChange = { codeText = it },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    textStyle = TextStyle(
                        color = Color.White,
                        fontFamily = FontFamily.Monospace
                    )
                )
            }
        }

        /* ---------- FIXED BUTTON ---------- */
        item {
            Button(
                onClick = {
                    codeViewModel.runCode(codeText) // 🔥 REAL API CALL
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text("Run Code")
            }
        }

        /* ---------- OUTPUT ---------- */
        if (output.isNotEmpty() || error.isNotEmpty()) {

            item {
                Text("Output")
            }

            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black, RoundedCornerShape(14.dp))
                        .padding(16.dp)
                ) {
                    Text(
                        text = if (error.isNotEmpty()) error else output,
                        color = if (error.isNotEmpty()) Color.Red else Color.Green,
                        fontFamily = FontFamily.Monospace
                    )
                }
            }
        }
    }
}
