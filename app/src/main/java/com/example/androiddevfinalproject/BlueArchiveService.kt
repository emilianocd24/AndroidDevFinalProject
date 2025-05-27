package com.example.androiddevfinalproject

import retrofit2.Call
import retrofit2.http.GET

interface BlueArchiveService {
    @GET("/api/")
    fun getAllBlueArchiveEntries() : Call<BlueArchiveCollection>
    // top level thing CALL<Type>
}