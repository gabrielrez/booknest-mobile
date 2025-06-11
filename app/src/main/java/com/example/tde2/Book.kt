package com.example.tde2

import java.io.Serializable

data class Book(
    val externalId: String,
    val title: String,
    val author: String,
    val description: String,
    val cover: String
)