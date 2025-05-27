package com.example.androiddevfinalproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BlueArchiveEntry(
    val _id: String,
    val name: String,
    val school: String,
    val birthday: String,
    val photoUrl: String,
    val imageSchool: String,
    val damageType: String
) : Parcelable
