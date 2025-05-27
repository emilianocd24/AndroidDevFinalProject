package com.example.androiddevfinalproject

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BlueArchiveRetrofitHelper {
    val baseUrl = "https://pgr-api.vercel.app"

    fun getInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}