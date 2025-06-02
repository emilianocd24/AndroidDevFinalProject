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

//    fun bind(data: GtalesEntry){
////        val textViewGTalesItemName: TextView = itemView.findViewById(R.id.textView_gTales_item_name)
////        textViewGTalesItemName.text = data.name
//        val layout: ConstraintLayout
//        layout = itemView.findViewById(R.id.layout_gTales_item)
//        layout.setOnClickListener{
//            val context = layout.context
//            // we need the context of the activity where the recycler view is located
//            val detailIntent = Intent(context, GtalesDetailActivity::class.java)
//            //Log.d("HyruleLissssst", "onResponse : OMG")
//
//            detailIntent.putExtra(GtalesDetailActivity.TALES_ENTRY, data, )
//            context.startActivity(detailIntent)
//
//            // Toast.makeText(context, "You clicked on ${earthquake.properties.}", Toast.LENGTH_SHORT).show()
//        }
}