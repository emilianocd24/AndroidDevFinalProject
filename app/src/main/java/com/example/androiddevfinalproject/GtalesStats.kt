package com.example.androiddevfinalproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GtalesStats(
    val hp: String,
    val atk: String,
    val def: String,
    val heal: String
) : Parcelable
