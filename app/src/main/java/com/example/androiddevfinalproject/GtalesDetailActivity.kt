package com.example.androiddevfinalproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddevfinalproject.databinding.ActivityGtalesDetailBinding

class GtalesDetailActivity: AppCompatActivity() {
    companion object{

        val TALES_ENTRY = "entry"
        val TAG = "CompendiumDetailActivity"

    }
    private lateinit var binding: ActivityGtalesDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGtalesDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val gTales = intent.getParcelableExtra<GtalesEntry>(TALES_ENTRY)
        binding.textViewGTalesDetailName.text = gTales!!.name
        //Picasso.get().load(.photoUrl).into(binding.imageViewBlueArchiveDetail)





    }
}