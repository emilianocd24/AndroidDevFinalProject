package com.example.androiddevfinalproject

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class GrayRavenViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(data: GrayRavenEntry){
        val textViewGrayRavenItemName: TextView = itemView.findViewById(R.id.textView_grayRaven_item_name)
        textViewGrayRavenItemName.text = data.name
        val layout: ConstraintLayout
        layout = itemView.findViewById(R.id.layout_grayRaven_item)
        layout.setOnClickListener{
            val context = layout.context
            // we need the context of the activity where the recycler view is located
            val detailIntent = Intent(context, GrayRavenDetailActivity::class.java)
            //Log.d("HyruleLissssst", "onResponse : OMG")

            detailIntent.putExtra(GrayRavenDetailActivity.RAVEN_ENTRY, data, )
            context.startActivity(detailIntent)
        }
    }
}