package com.example.androiddevfinalproject

import retrofit2.Call
import retrofit2.http.GET

interface GrayRavenService {
    @GET("/api/")
    fun getAllGrayRavenEntries() : Call<GrayRavenCollection>
    // top level thing CALL<Type>
}