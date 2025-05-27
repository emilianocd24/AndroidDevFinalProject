package com.example.androiddevfinalproject

sealed class GachaCharacter{
    data class GrayRavenCharacter(val gachaCharacter: GrayRavenEntry) : GachaCharacter()
    data class GtalesCharacter(val gachaCharacter: GtalesEntry) : GachaCharacter()
}
