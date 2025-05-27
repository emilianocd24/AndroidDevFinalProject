package com.example.androiddevfinalproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GrayRavenCollection(
    val lotus: GrayRavenEntry,
    val eclipse: GrayRavenEntry,
    val storm: GrayRavenEntry,
    val dawn: GrayRavenEntry,
    val lux: GrayRavenEntry,
    val palefire: GrayRavenEntry,
    val nightblade: GrayRavenEntry,
    val zero: GrayRavenEntry,
    val blast: GrayRavenEntry,
    val luminance: GrayRavenEntry,
    val entropy: GrayRavenEntry,
    val ember: GrayRavenEntry,
    val pulse: GrayRavenEntry,
    val tenebrion: GrayRavenEntry,
    val crimsonabyss: GrayRavenEntry,
    val bastion: GrayRavenEntry,
    val astral: GrayRavenEntry,
    val brilliance: GrayRavenEntry,
    val veritas: GrayRavenEntry,
    val silverfang: GrayRavenEntry,
    val arclight: GrayRavenEntry,
    val plume: GrayRavenEntry,
    val rozen: GrayRavenEntry,
    val crocotta: GrayRavenEntry,
    val rigor: GrayRavenEntry,
    val qilin: GrayRavenEntry,
    val pavo: GrayRavenEntry,
    val laurel: GrayRavenEntry,
    val `2b`: GrayRavenEntry,
    val `9s`: GrayRavenEntry,
    val a2: GrayRavenEntry,
    val hypnos: GrayRavenEntry,
    val tempest: GrayRavenEntry,
    val glory: GrayRavenEntry,
    val xxi: GrayRavenEntry,
    val garnet: GrayRavenEntry,
    val flambeau: GrayRavenEntry,
    val empyrea: GrayRavenEntry,
    val capriccio: GrayRavenEntry,
    val dragontoll: GrayRavenEntry,
    val starfarer: GrayRavenEntry,
    val starveil: GrayRavenEntry,
    val scire: GrayRavenEntry,
    val arca: GrayRavenEntry,
    val stigmata: GrayRavenEntry,
    val vitrum: GrayRavenEntry,
    val hyperreal: GrayRavenEntry,
    val kaleido: GrayRavenEntry,
    val crimsonweave: GrayRavenEntry,
    val zitherwoe: GrayRavenEntry,
    val feralscent: GrayRavenEntry,
    val indomitus: GrayRavenEntry,
    val echo: GrayRavenEntry,
    val lostlullaby: GrayRavenEntry,
    val brs: GrayRavenEntry,
    val epitaph: GrayRavenEntry,
    val shukra: GrayRavenEntry,
    val unknown: GrayRavenEntry

) : Parcelable
{
    fun toList(): List<GrayRavenEntry> = listOf(
        lotus, eclipse, storm, dawn, lux, palefire, nightblade,
        zero, blast, luminance, entropy, ember, pulse,
        tenebrion, crimsonabyss, bastion, astral, brilliance, veritas, silverfang, arclight,
        plume, rozen, crocotta, rigor, qilin, pavo, laurel, `2b`, `9s`, a2, hypnos, tempest,
     glory, xxi, garnet, flambeau, empyrea, capriccio, dragontoll, starfarer, starveil,
        scire, arca, stigmata, vitrum, hyperreal, kaleido, crimsonweave, zitherwoe,
        feralscent, indomitus, echo, lostlullaby, brs, epitaph, shukra, unknown
    )
}
