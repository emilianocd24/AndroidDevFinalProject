package com.example.androiddevfinalproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GtalesEntry(
    val key: String,
    val name: String,
    val atr: String,
    val element: String,
    val rarity: String,
    val role: String,
    val collection: String,
    val stats: GtalesStats,
    val variants: List<GtalesVariants>
) : Parcelable
