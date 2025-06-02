package com.example.androiddevfinalproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class GachaCharacter : Parcelable{
    @Parcelize
    data class GrayRavenCharacter(val gachaCharacter: GrayRavenEntry) : GachaCharacter()
    @Parcelize
    data class GtalesCharacter(val gachaCharacter: GtalesEntry) : GachaCharacter()
}
