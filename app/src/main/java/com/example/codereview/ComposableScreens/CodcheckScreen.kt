package com.example.codereview.ComposableScreens


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
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
fun CodecheckScreen() {

    val languages = listOf(
        "Kotlin", "Java", "Python", "C", "C++",
        "JavaScript", "Go", "Rust", "Swift", "PHP"
    )

    var selectedLanguage by remember { mutableStateOf("Kotlin") }
    var codeText by remember { mutableStateOf("") }
    var outputText by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F172A)),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {

        /* ---------- TITLE ---------- */
        item {
            Text(
                text = "Code Runner",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        /* ---------- LANGUAGE CHIPS ---------- */
        item {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                items(languages) { lang ->
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(
                                if (lang == selectedLanguage)
                                    Color(0xFF3B82F6)
                                else
                                    Color(0xFF1E293B)
                            )
                            .clickable { selectedLanguage = lang }
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Text(
                            text = lang,
                            color = Color.White,
                            fontSize = 13.sp
                        )
                    }
                }
            }
        }

        /* ---------- CODE EDITOR ---------- */
        item {
            Column {
                Text(
                    text = "Editor ($selectedLanguage)",
                    color = Color(0xFFCBD5F5),
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(6.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(Color(0xFF020617))
                        .padding(12.dp)
                ) {
                    BasicTextField(
                        value = codeText,
                        onValueChange = { codeText = it },
                        modifier = Modifier.fillMaxSize(),
                        textStyle = TextStyle(
                            color = Color(0xFFE5E7EB),
                            fontFamily = FontFamily.Monospace,
                            fontSize = 14.sp
                        ),
                        cursorBrush = SolidColor(Color.White),
                        decorationBox = { innerTextField ->
                            if (codeText.isEmpty()) {
                                Text(
                                    text = "// Write your code here",
                                    color = Color(0xFF64748B),
                                    fontFamily = FontFamily.Monospace
                                )
                            }
                            innerTextField()
                        }
                    )
                }
            }
        }

        /* ---------- RUN BUTTON ---------- */
        item {
            Button(
                onClick = {
                    outputText =
                        "✔ Code Executed\n\nOutput:\nHello from $selectedLanguage 🚀"
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF22C55E)
                )
            ) {
                Text("Run Code", fontSize = 16.sp)
            }
        }

        /* ---------- OUTPUT ---------- */
        if (outputText.isNotEmpty()) {
            item {
                Column {
                    Text(
                        text = "Output",
                        color = Color(0xFFCBD5F5),
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(14.dp))
                            .background(Color(0xFF020617))
                            .padding(14.dp)
                    ) {
                        Text(
                            text = outputText,
                            color = Color(0xFF22C55E),
                            fontFamily = FontFamily.Monospace
                        )
                    }
                }
            }
        }

        /* ---------- SUBMISSION ACTIVITY ---------- */
        item {
            Text(
                text = "Submission Activity",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }

        item {
            CodeProgressBar(
                title = "Weekly Code Submitted",
                progress = 0.65f,
                color = Color(0xFF3B82F6)
            )
        }

        item {
            CodeProgressBar(
                title = "Monthly Submissions (3 / 10)",
                progress = 0.30f,
                color = Color(0xFFF97316)
            )
        }

        /* ---------- AI CHECK BUTTON (Future Ready) ---------- */
        item {
            Button(
                onClick = { /* AI CHECK API HERE */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF8B5CF6)
                )
            ) {
                Text("AI Code Review & Improvement")
            }
        }
    }
}
