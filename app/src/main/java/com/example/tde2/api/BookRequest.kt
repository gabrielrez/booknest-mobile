package com.example.tde2.api

data class BookRequest(
    val external_id: String,
    val title: String,
    val description: String,
    val author: String = "",
    val cover: String? = null
)
