package com.example.androiddevfinalproject

import android.content.Context
import org.json.JSONObject

object GtalesImageLoader {
    fun loadGtalesImageMap(context: Context): Map<String, String> {
        val inputStream = context.resources.openRawResource(R.raw.gtales_images)
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        val jsonObject = JSONObject(jsonString)
        val imageMap = mutableMapOf<String, String>()
        val keys = jsonObject.keys()
        while (keys.hasNext()) {
            val name = keys.next()
            val url = jsonObject.getString(name)
            imageMap[name] = url
        }
        return imageMap
    }
}
