package com.example.androiddevfinalproject

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GtalesRetrofitHelper {
    val baseUrl = "https://www.gtales.top"

    fun getInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}