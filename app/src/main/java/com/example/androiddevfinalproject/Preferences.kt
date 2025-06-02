package com.example.androiddevfinalproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Preferences(
    var ownerId: String? = null,
    var objectId: String? = null,
    var playsGrayRaven: Boolean = true,
    var playsGuardianTales: Boolean = true
) : Parcelable
