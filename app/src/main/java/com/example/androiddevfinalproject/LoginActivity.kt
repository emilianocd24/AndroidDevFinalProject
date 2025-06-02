package com.example.androiddevfinalproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.backendless.Backendless
import com.backendless.BackendlessUser
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault
import com.backendless.persistence.DataQueryBuilder
import com.example.androiddevfinalproject.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    companion object {
        // the values to send in intents are called Extras
        // and have the EXTRA_BLAH format for naming the key
        val EXTRA_USERNAME = "username"
        val EXTRA_PASSWORD = "password"
        //val PLAYS_GRAY_RAVEN = "Plays Gray Raven"
        //val PLAYS_GUARDIAN_TALES = "Plays Guardian Tales"
        val EXTRA_USER_ID = "userId"
        val ACTIVATED_REGISTRATION = "Did they sign up?"
        val EXTRA_PREFERENCES = "User Preferences"
    }

//    val startRegistrationForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
//            result: ActivityResult ->
//        if (result.resultCode == Activity.RESULT_OK) {
//            val intent = result.data
//            // Handle the Intent to do whatever we need with the returned info
//            binding.editTextLoginUsername.setText(intent?.getStringExtra(EXTRA_USERNAME))
//            binding.editTextLoginPassword.setText(intent?.getStringExtra(EXTRA_PASSWORD))
//
//        }

//    }


    private lateinit var binding: ActivityLoginBinding
        //private var playsGrayRaven: Boolean = true
        //private var playsGtales: Boolean = true
    //val playsGrayRaven = intent.getBooleanExtra(PLAYS_GRAY_RAVEN, false)
    //val playsGtales = intent.getBooleanExtra(PLAYS_GUARDIAN_TALES, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val activatedRegistration = intent.getBooleanExtra(ACTIVATED_REGISTRATION, false)
        if(activatedRegistration){
            binding.editTextLoginUsername.setText(intent?.getStringExtra(EXTRA_USERNAME))
            binding.editTextLoginPassword.setText(intent?.getStringExtra(EXTRA_PASSWORD))
        }

        binding.editTextLoginUsername.setText("Name")

        // register with backendless
        Backendless.initApp(this, Constants.API_ID, Constants.API_KEY)
        // do not forget to call Backendless.initApp in the app initialization code
        binding.buttonLoginLogin.setOnClickListener{
            // extreact the use and password from edittexts and login
            val username = binding.editTextLoginUsername.text.toString()
            val password = binding.editTextLoginPassword.text.toString()
            Backendless.UserService.login(username, password, object : AsyncCallback<BackendlessUser?> {
                    override fun handleResponse(user: BackendlessUser?) {
                        // user has been logged in
                        // go to game list activity intent
                        Toast.makeText(this@LoginActivity,
                            "${user?.userId} has logged in", Toast.LENGTH_SHORT).show()
                        // go to gamelist act
                        val characterListIntent = Intent(this@LoginActivity, CharacterListActivity::class.java)
                        val playsGtales: Boolean
                        val playsGrayRaven: Boolean
                        var preferences: Preferences
                        val userId = user?.userId
                        val  whereClause = "ownerId = '$userId'"
                        val queryBuilder = DataQueryBuilder.create()
                        queryBuilder.setWhereClause(whereClause)
                        Backendless.Data.of(Preferences::class.java).find(queryBuilder,
                            object : AsyncCallback<List<Preferences>> {
                                override fun handleResponse(foundPreferences: List<Preferences>) {
                                    // the "foundContact" collection now contains instances of the Contact class.
                                    // each instance represents an object stored on the server.
                                    preferences = foundPreferences.first()
                                    characterListIntent.putExtra(CharacterListActivity.EXTRA_PREFERENCES, preferences)
                                    characterListIntent.putExtra(CharacterListActivity.EXTRA_USER_ID, user?.userId)
                                    // might need to send the user id across later
                                    startActivity(characterListIntent)
                                }
                                override fun handleFault(fault: BackendlessFault) {
                                // an error has occurred, the error code can be retrieved with fault.getCode()
                                }
                            })
                        //val playsGrayRaven = intent.getBooleanExtra(PLAYS_GRAY_RAVEN, false)
                        //val playsGtales = intent.getBooleanExtra(PLAYS_GUARDIAN_TALES, false)

//                        characterListIntent.putExtra(CharacterListActivity.PLAYS_GRAY_RAVEN, preferences.playsGrayRaven)
//                        characterListIntent.putExtra(CharacterListActivity.PLAYS_GUARDIAN_TALES, playsGtales)

//                        characterListIntent.putExtra(CharacterListActivity.EXTRA_USER_ID, user?.userId)
//                        // might need to send the user id across later
//                        startActivity(characterListIntent)
                    }

                    override fun handleFault(fault: BackendlessFault) {
                        // login failed, to get the error code call fault.getCode()
                        Log.d("HyruleLissssst", "onFailure: ${fault.code}")
                        Toast.makeText(this@LoginActivity, "${fault.message}", Toast.LENGTH_SHORT).show()
                    }
                })

        }

        // launch the Registration Activity
        binding.textViewLoginSignup.setOnClickListener {
            // 1. Create an Intent object with the current activity
            // and the destination activity's class
            val registrationIntent = Intent(this,
                RegistrationActivity::class.java)
            // 2. optionally add information to send with the intent
            // key-value pairs just like with Bundles
            registrationIntent.putExtra(EXTRA_USERNAME,
                binding.editTextLoginUsername.text.toString())
            registrationIntent.putExtra(EXTRA_PASSWORD,
                binding.editTextLoginPassword.text.toString())
//            // 3a. launch the new activity using the intent
//            startActivity(registrationIntent)
            // 3b. Launch the activity for a result using the variable from the
            // register for result contract above
            startActivity(registrationIntent)
            //startRegistrationForResult.launch(registrationIntent)
        }
    }
}