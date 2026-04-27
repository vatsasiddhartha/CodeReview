package com.example.codereview.data

data class CompileResponse(

    val run:RunResult
)
data class RunResult(
    val stdout:String,
    val stderr:String,
    val code: Int
)
