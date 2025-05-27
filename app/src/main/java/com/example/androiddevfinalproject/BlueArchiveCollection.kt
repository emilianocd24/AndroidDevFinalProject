package com.example.androiddevfinalproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BlueArchiveCollection (
    val data: Array<BlueArchiveEntry>
) : Parcelable