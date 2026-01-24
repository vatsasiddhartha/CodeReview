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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CoderunScreen() {

    val languages = listOf(
        "Kotlin", "Java", "Python", "C", "C++",
        "JavaScript", "Go", "Rust", "Swift", "PHP"
    )

    var selectedLanguage by remember { mutableStateOf("Kotlin") }
    var codeText by remember { mutableStateOf("") }
    var outputText by remember { mutableStateOf("") }

    val editorScroll = rememberScrollState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2F6FB)),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        /* ---------- HEADER ---------- */
        item {
            Text(
                text = "Code Runner",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1E2A38)
            )
        }

        /* ---------- LANGUAGE SELECTOR ---------- */
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
                                Color.White else Color(0xFF34495E)
                        )
                    }
                }
            }
        }

        /* ---------- EDITOR LABEL ---------- */
        item {
            Text(
                text = "Editor ($selectedLanguage)",
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF34495E)
            )
        }

        /* ---------- CODE EDITOR (FIXED HEIGHT) ---------- */
        item {
            val lines = maxOf(1, codeText.count { it == '\n' } + 1)

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp) // 🔑 VERY IMPORTANT
                    .background(
                        Color(0xFF0F172A),
                        RoundedCornerShape(16.dp)
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp)
                        .verticalScroll(editorScroll)
                ) {

                    Column(
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        repeat(lines) {
                            Text(
                                text = "${it + 1}",
                                fontFamily = FontFamily.Monospace,
                                fontSize = 13.sp,
                                color = Color(0xFF64748B)
                            )
                        }
                    }

                    BasicTextField(
                        value = codeText,
                        onValueChange = { codeText = it },
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(
                            color = Color(0xFFE5E7EB),
                            fontFamily = FontFamily.Monospace,
                            fontSize = 14.sp
                        ),
                        cursorBrush = SolidColor(Color.White)
                    )
                }
            }
        }

        /* ---------- RUN BUTTON ---------- */
        item {
            Button(
                onClick = {
                    outputText =
                        "✔ Code executed successfully\n\nOutput:\nHello from $selectedLanguage 🚀"
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4A90E2)
                )
            ) {
                Text("Run Code", fontSize = 16.sp)
            }
        }

        /* ---------- OUTPUT ---------- */
        if (outputText.isNotEmpty()) {
            item {
                Text(
                    text = "Output",
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF34495E)
                )
            }

            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Color(0xFF0F172A),
                            RoundedCornerShape(14.dp)
                        )
                        .padding(16.dp)
                ) {
                    Text(
                        text = outputText,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 14.sp,
                        color = Color(0xFF22C55E)
                    )
                }
            }
        }
    }
}

