package com.example.androiddevfinalproject

import retrofit2.Call
import retrofit2.http.GET

interface GtalesService {
    @GET("/api/heroes")
    fun getAllTestEntries() : Call<List<GtalesEntry>>
    // top level thing CALL<Type>
}