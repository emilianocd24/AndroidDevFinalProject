package com.example.androiddevfinalproject

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.backendless.Backendless
import com.backendless.BackendlessUser
import com.backendless.async.callback.AsyncCallback
import com.backendless.async.callback.Fault
import com.backendless.exceptions.BackendlessFault
import com.example.androiddevfinalproject.databinding.ActivitySelectpreferencesListBinding


class GameSelectionActivity: AppCompatActivity() {
    companion object {
        // the values to send in intents are called Extras
        // and have the EXTRA_BLAH format for naming the key
        //val EXTRA_USERNAME = "username"
        //val  = "password"
    }

    private lateinit var binding: ActivitySelectpreferencesListBinding
    private var grayRavenPlayer: Boolean = true
    var gtalesPlayer: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectpreferencesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.checkboxGrayRaven.setOnCheckedChangeListener{ buttonView, isChecked ->
    Log.d("CHECKBOXES", "Meat is checked: $isChecked")
            //binding.checkboxGrayRaven.toggle()
            grayRavenPlayer = !grayRavenPlayer
}
        binding.checkboxGtales.setOnCheckedChangeListener { buttonView, isChecked ->
            Log.d("CHECKBOXES", "Cheese is checked: $isChecked")
            //binding.checkboxGtales.toggle()
            gtalesPlayer = !gtalesPlayer
        }

        binding.buttonSelectPreferencesConfirm.setOnClickListener {
            val preferences = Preferences()
            preferences.playsGrayRaven = grayRavenPlayer
            preferences.playsGuardianTales = gtalesPlayer
            preferences.ownerId = Backendless.UserService.CurrentUser().userId
            Backendless.Data.of(Preferences::class.java).save(preferences, object :
                AsyncCallback<Preferences?> {
                override fun handleResponse(response: Preferences?) {
                    // new Contact instance has been saved
                    Log.d("We win these" , "Wins")

                    val backToLoginIntent = Intent(this@GameSelectionActivity, LoginActivity::class.java)
                    val currentPreferences: Preferences
                    backToLoginIntent.putExtra(LoginActivity.EXTRA_PREFERENCES, preferences)
                    //backToLoginIntent.putExtra(LoginActivity.PLAYS_GUARDIAN_TALES, gtalesPlayer)
                    backToLoginIntent.putExtra(LoginActivity.ACTIVATED_REGISTRATION, true)
                    startActivity(backToLoginIntent)

                }

                override fun handleFault(fault: BackendlessFault) {
                    // an error has occurred, the error code can be retrieved with fault.getCode()
                    Log.d("Why I fail?" , "This why ${fault.message}")
                }
            })

//            val backToLoginIntent = Intent(this, LoginActivity::class.java)
//            val currentPreferences: Preferences
//            backToLoginIntent.putExtra(LoginActivity.EXTRA_PREFERENCES, preferences)
//            //backToLoginIntent.putExtra(LoginActivity.PLAYS_GUARDIAN_TALES, gtalesPlayer)
//            backToLoginIntent.putExtra(LoginActivity.ACTIVATED_REGISTRATION, true)
            //finish()
        }


    }
}