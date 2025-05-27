package com.example.androiddevfinalproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView


class TestAdapter(var dataSet: List<GtalesEntry>) :
    RecyclerView.Adapter<TestAdapter.ViewHolder>() {
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //val textView: TextView
        //val imageViewItem: ImageView = view.findViewById(R.id.imageView_blueArchive_item)
        //val textViewItemName: TextView = view.findViewById(R.id.textView_blueArchive_item_name)
        val textViewGTalesItemName: TextView = view.findViewById(R.id.textView_gTales_item_name)
        val layout: ConstraintLayout



        init {
            layout = view.findViewById(R.id.layout_gTales_item)
        }

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_gtales_entry, viewGroup, false)

        return ViewHolder(view)
    }


    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textViewGTalesItemName.text = dataSet[position].name
        // Picasso.get().load(dataSet[position].photoUrl).into(viewHolder.imageViewItem)
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        //viewHolder.textView.text = dataSet[position]
        //val datas = dataSet[position]

        viewHolder.layout.setOnClickListener{
            val context = viewHolder.layout.context
            // we need the context of the activity where the recycler view is located
            val detailIntent = Intent(context, GtalesDetailActivity::class.java)
            //Log.d("HyruleLissssst", "onResponse : OMG")

            detailIntent.putExtra(GtalesDetailActivity.TALES_ENTRY, dataSet[position], )
            context.startActivity(detailIntent)

            // Toast.makeText(context, "You clicked on ${earthquake.properties.}", Toast.LENGTH_SHORT).show()
        }
    }

    // Return the size of your dataset (invoked by the layout manager)

    override fun getItemCount() = dataSet.size


}