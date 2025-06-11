package com.example.tde2.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://10.0.2.2:8000/"
    private const val TOKEN = "Bearer 5|QfIMAB9lYOg5fuORXORUsgiiPLf0kaVs6K1Y8qHG733c6742"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain: Interceptor.Chain ->
            val originalRequest: Request = chain.request()
            val requestWithHeaders = originalRequest.newBuilder()
                .header("Authorization", TOKEN)
                .build()
            chain.proceed(requestWithHeaders)
        }
        .build()

    val instance: BookApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(BookApiService::class.java)
    }
}
