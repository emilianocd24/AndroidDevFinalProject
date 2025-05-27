package com.example.androiddevfinalproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddevfinalproject.databinding.ActivityGrayravenDetailBinding
import com.squareup.picasso.Picasso

class GrayRavenDetailActivity: AppCompatActivity() {
    companion object{

        val RAVEN_ENTRY = "entry"
        val TAG = "CompendiumDetailActivity"

    }
    private lateinit var binding: ActivityGrayravenDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGrayravenDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val grayRaven = intent.getParcelableExtra<GrayRavenEntry>(RAVEN_ENTRY)
        binding.textViewGrayRavenDetailName.text = grayRaven!!.name
    //Picasso.get().load(.photoUrl).into(binding.imageViewBlueArchiveDetail)





    }
}