package com.example.androiddevfinalproject

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class GrayRavenViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.textView_grayRaven_item_name)
    val image: ImageView = itemView.findViewById(R.id.imageView_grayRaven_item_gameLogo)

       // val layout: ConstraintLayout
//        layout = itemView.findViewById(R.id.layout_grayRaven_item)
//        layout.setOnClickListener{
//            val context = layout.context
//            // we need the context of the activity where the recycler view is located
//            val detailIntent = Intent(context, GrayRavenDetailActivity::class.java)
//            //Log.d("HyruleLissssst", "onResponse : OMG")
//            layout.getViewById(R.id.textView_grayRaven_item_name)
//            detailIntent.putExtra(GrayRavenDetailActivity.RAVEN_ENTRY, data, )
//            context.startActivity(detailIntent)
//        }

}