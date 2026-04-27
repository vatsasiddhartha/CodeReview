package com.example.codereview.model

import com.example.codereview.data.CodeRequest
import com.example.codereview.data.CompileResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("excecute")
    suspend fun executeCode(
        @Body request: CodeRequest
    ): CompileResponse
}