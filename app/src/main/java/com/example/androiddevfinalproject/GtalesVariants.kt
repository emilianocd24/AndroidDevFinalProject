package com.example.androiddevfinalproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GtalesVariants(
    val name: String,
    val party: String,
    val weaponCollection: String,
    val weaponEngraving: String
) : Parcelable
