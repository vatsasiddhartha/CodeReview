package com.example.codereview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CodeReviewViewModel : ViewModel() {

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.Initial)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val generativeModel = GenerativeModel(
        modelName = "gemini-pro", // Adjust the model name for code review purposes
        apiKey = com.example.codereview.BuildConfig.apiKey
    )

    fun sendPrompt(codeInput: String) {
        // Update UI state to loading immediately
        _uiState.value = UiState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                // Validate input before sending to the model
                if (codeInput.isEmpty()) {
                    _uiState.value = UiState.Error("Please enter code for review.")
                    return@launch
                }

                // Assuming that the Gemini API's `generateContent` works with code input
                val response = generativeModel.generateContent(
                    content {
                        text(codeInput) // Send the code for review
                    }
                )
                val reviewResult = response.text ?: "" // Handle empty response gracefully

                _uiState.value = UiState.Success(reviewResult)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.localizedMessage ?: "Unknown error")
            }
        }
    }
}