package com.example.androiddevfinalproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GrayRavenEntry(
    val name: String,
    val title: String,
    val rank: String,
    val `class`: String,
    val element: String,
    val weapon: String,
    val signature: String,
    val faction: String,
    val gift: String,
    val serviceTime: String,
    val mentalAge: String,
    val activationDate: String,
    val height: String,
    val weight: String,
    val vitalFluidType: String
) : Parcelable
