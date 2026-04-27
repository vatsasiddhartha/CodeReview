package com.example.codereview.repository

import com.example.codereview.data.CodeRequest
import com.example.codereview.data.CompileResponse
import com.example.codereview.data.FileData
import com.example.codereview.model.ApiService

class CodeRepository(private val api: ApiService) {

    suspend fun executeCode(code: String): CompileResponse {

        val request = CodeRequest(
            language = "python",
            version = "3.10.0",
            files = listOf(
                FileData("main.py", code)
            )
        )

        return api.executeCode(request)
    }
}
