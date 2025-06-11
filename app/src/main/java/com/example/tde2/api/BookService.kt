package com.example.tde2.api

import com.example.tde2.Book
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApiService {
    @GET("api/books/search")
    fun searchBooks(@Query("book_name") bookName: String): Call<List<Book>>
}
