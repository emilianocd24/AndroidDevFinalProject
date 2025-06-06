package com.example.androiddevfinalproject

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androiddevfinalproject.LoginActivity.Companion
import com.example.androiddevfinalproject.LoginActivity.Companion.ACTIVATED_REGISTRATION
import com.example.androiddevfinalproject.databinding.ActivityCharactersListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharactersListBinding
    private lateinit var adapter: CharacterAdapter

    companion object{
//        val PLAYS_GRAY_RAVEN = "Gray Raven Player"
//        val PLAYS_GUARDIAN_TALES = "Guardian Tales Player"
        val EXTRA_PREFERENCES = "User Preferences"
        val EXTRA_USER_ID = "UserId"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCharactersListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val userPreferences = intent.getParcelableExtra<Preferences>(EXTRA_PREFERENCES)!!
        var grayRavenEntry: List<GrayRavenEntry>? = null
        var gtalesEntry: List<GtalesEntry>? = null

        val grayRavenService = GrayRavenRetrofitHelper.getInstance().create(GrayRavenService::class.java)
        val grayRavenCall = grayRavenService.getAllGrayRavenEntries()

        val gTalesService = GtalesRetrofitHelper.getInstance().create(GtalesService::class.java)
        val gTalesCall = gTalesService.getAllTestEntries()
        val action=supportActionBar
        action?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#000000")))
        adapter = CharacterAdapter()
        binding.recylerViewCharctersList.adapter = adapter
        binding.recylerViewCharctersList.layoutManager = LinearLayoutManager(this)
//        val playsGrayRaven = intent.getBooleanExtra(LoginActivity.PLAYS_GRAY_RAVEN, false)
//        val playsGtales = intent.getBooleanExtra(LoginActivity.PLAYS_GUARDIAN_TALES, false)
        //mixedCharacterList += grayRavenEntry!!.map { GachaCharacter.GrayRavenCharacter(it) }
        //mixedCharacterList += gtalesEntry!!.map { GachaCharacter.GtalesCharacter(it) }
        fun tryUpdateMixedList() {
            if (grayRavenEntry!= null && gtalesEntry != null) {
                val mixedCharacterList = mutableListOf<GachaCharacter>()
                if (userPreferences.playsGrayRaven) {
                    mixedCharacterList += grayRavenEntry!!.map { GachaCharacter.GrayRavenCharacter(it) }
                }

                if (userPreferences.playsGuardianTales) {
                    mixedCharacterList += gtalesEntry!!.map { GachaCharacter.GtalesCharacter(it) }
                }
                adapter.setItems(mixedCharacterList)
            }
        }
        grayRavenCall.enqueue(object: Callback<GrayRavenCollection> {
            override fun onResponse(call: Call<GrayRavenCollection>,
                                    response: Response<GrayRavenCollection>
            ) {
                if (response.isSuccessful){
                    grayRavenEntry = response.body()?.toList()
                    tryUpdateMixedList()
                }

                Log.d("HyruleList", "onResponse : ${response.body()}")
            }
            override fun onFailure(call: Call<GrayRavenCollection>, t: Throwable) {
                Log.d("EarthquakeList", "onFailure: ${t.message}")
                t.cause
            }
        })
        gTalesCall.enqueue(object: Callback<List<GtalesEntry>> {
            override fun onResponse(call: Call<List<GtalesEntry>>,
                                    response: Response<List<GtalesEntry>>
            ) {
                if(response.isSuccessful){
                    gtalesEntry = response.body()
                    tryUpdateMixedList()
                }
            }
            override fun onFailure(call: Call<List<GtalesEntry>>, t: Throwable) {
                Log.d("EarthquakeList", "onFailure: ${t.message}")
                t.cause
            }
        })
    }

}