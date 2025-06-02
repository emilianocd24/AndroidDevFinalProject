package com.example.androiddevfinalproject

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class GtalesViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.textView_gTales_item_name)
    val gameLogo: ImageView = itemView.findViewById(R.id.imageView_gtales_item_gameLogo)
    val characterImage : ImageView = itemView.findViewById(R.id.imageView_gTales_item_characterImage)

}