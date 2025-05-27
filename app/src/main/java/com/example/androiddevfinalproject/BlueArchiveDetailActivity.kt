package com.example.androiddevfinalproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddevfinalproject.databinding.ActivityBluearchiveDetailBinding
import com.squareup.picasso.Picasso

class BlueArchiveDetailActivity: AppCompatActivity() {
    companion object{

        val ARCHIVE_ENTRY = "entry"
        val TAG = "CompendiumDetailActivity"

    }
    private lateinit var binding: ActivityBluearchiveDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityBluearchiveDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val blueArchive = intent.getParcelableExtra<BlueArchiveEntry>(ARCHIVE_ENTRY)
        binding.textViewBlueArchiveDetailName.text = blueArchive!!.name
        Picasso.get().load(blueArchive.photoUrl).into(binding.imageViewBlueArchiveDetail)





    }
}