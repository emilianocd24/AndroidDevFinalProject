package com.example.androiddevfinalproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CharacterAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<GachaCharacter> = emptyList()

    companion object {
        private const val TYPE_GRAY_RAVEN = 0
        private const val TYPE_GTALES = 1
    }

//    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        //val textView: TextView
//        //val imageViewItem: ImageView = view.findViewById(R.id.imageView_blueArchive_item)
//        //val textViewItemName: TextView = view.findViewById(R.id.textView_blueArchive_item_name)
//        //val textViewGrayRavenItemName: TextView = view.findViewById(R.id.textView_grayRaven_item_name)
//        val layout: ConstraintLayout
//
//
//
//        init {
//            layout = view.findViewById(R.id.layout_grayRaven_item)
//        }
//
//    }
    fun setItems(newItems: List<GachaCharacter>) {
        items = newItems
        notifyDataSetChanged() // Replace with DiffUtil if needed
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is GachaCharacter.GrayRavenCharacter -> TYPE_GRAY_RAVEN
            is GachaCharacter.GtalesCharacter -> TYPE_GTALES
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType){
            TYPE_GRAY_RAVEN -> {
                val view = LayoutInflater.from(viewGroup.context).
                inflate(R.layout.item_grayraven_entry, viewGroup, false)
                GrayRavenViewHolder(view)
            }
            TYPE_GTALES -> {
                val view = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.item_gtales_entry, viewGroup, false)
                GtalesViewHolder(view)
            }
            else -> throw IllegalArgumentException("Unknown viewType")
        }
    }
    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is GachaCharacter.GrayRavenCharacter -> {
                val grayRavenHolder = holder as GrayRavenViewHolder

                grayRavenHolder.name.text = item.gachaCharacter.name
                Picasso.get()
                    .load("https://www.gamegrin.com/assets/game/punishing-gray-raven/logo/_res" +
                            "ampled/SetWidth1920-punishing-gray-raven-logo-1.png")
                    .resize(140,125)
                    .centerCrop()
                    .into(grayRavenHolder.image)
                grayRavenHolder.itemView.setOnClickListener {
                    val context = it.context
                    val detailIntent = Intent(context, GrayRavenDetailActivity::class.java)
                    detailIntent.putExtra(GrayRavenDetailActivity.RAVEN_ENTRY, item.gachaCharacter)
                    context.startActivity(detailIntent)
                }
            }
            is GachaCharacter.GtalesCharacter -> {
                val gTalesHolder = holder as GtalesViewHolder

                val context = holder.itemView.context
                val imageMap = GtalesImageLoader.loadGtalesImageMap(context)
                val characterName = item.gachaCharacter.name
                val imageUrl = imageMap[characterName]
                if (imageUrl != null){
                    Picasso.get().load(imageUrl).resize(140,125)
                        .centerCrop().into(gTalesHolder.characterImage)
                }

                    gTalesHolder.name.text = item.gachaCharacter.name
                Picasso.get()
                    .load("https://static.wikia.nocookie.net/guardian" +
                            "-tales/images/0/03/Guardian_Tales_Logo.png/revision/latest?cb=20210608170242")
                    .resize(140,125)
                    .centerCrop()
                    .into(gTalesHolder.gameLogo)
                    gTalesHolder.itemView.setOnClickListener {
                        val context = it.context
                        val detailActivity = Intent(context, GtalesDetailActivity::class.java)
                        detailActivity.putExtra(GtalesDetailActivity.TALES_ENTRY, item.gachaCharacter)
                        context.startActivity(detailActivity)
                    }

                }
        }

        //viewHolder.textViewGrayRavenItemName.text = items[position].name
       // Picasso.get().load(dataSet[position].photoUrl).into(viewHolder.imageViewItem)

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        //viewHolder.textView.text = dataSet[position]
        //val datas = dataSet[position]
//        viewHolder.layout.setOnClickListener{
//            val context = viewHolder.layout.context
//            // we need the context of the activity where the recycler view is located
//            val detailIntent = Intent(context, GrayRavenDetailActivity::class.java)
//            //Log.d("HyruleLissssst", "onResponse : OMG")
//
//            detailIntent.putExtra(GrayRavenDetailActivity.RAVEN_ENTRY, dataSet[position], )
//            context.startActivity(detailIntent)
//
//            // Toast.makeText(context, "You clicked on ${earthquake.properties.}", Toast.LENGTH_SHORT).show()
//        }
    }

    // Return the size of your dataset (invoked by the layout manager)

    override fun getItemCount(): Int = items.size


}