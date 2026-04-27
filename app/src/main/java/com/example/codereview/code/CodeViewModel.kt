package com.example.codereview.code

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codereview.model.RetrofitClient
import com.example.codereview.repository.CodeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class CodeViewModel : ViewModel() {

    private val repo = CodeRepository(RetrofitClient.api)

    val output = MutableStateFlow("")
    val error = MutableStateFlow("")
    val loading = MutableStateFlow(false)   // ✅ Boolean

    fun runCode(code: String) {
        if (code.isBlank()) {
            error.value = "Code cannot be empty"
            return
        }

        viewModelScope.launch {
            loading.value = true                     // ✅ clean

            try {
                val response = repo.executeCode(code)
                if (response.run.stderr.isNotEmpty()) {
                    error.value = response.run.stderr
                } else {
                    output.value = response.run.stdout
                }
            } catch (e: Exception) {
                error.value = e.message ?: "Unknown error"
            } finally {
                loading.value = false                // ✅ clean
            }
        }
    }
}
