package com.example.fitapet.retrofit

import com.example.fitapet.retrofit.service.RetrofitService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val BASE_URL_API ="http://118.45.212.21:3000/"
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL_API)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiServer = retrofit.create(RetrofitService::class.java)
}