package com.example.codereview.data

data class CodeRequest(
    val language: String,
    val version : String,
    val files:List<FileData>,



)
data class FileData(
    val name:String,
    val content: String
)
