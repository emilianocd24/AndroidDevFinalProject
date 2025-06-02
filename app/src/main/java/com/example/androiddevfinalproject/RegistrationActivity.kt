package com.example.androiddevfinalproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.backendless.Backendless
import com.backendless.BackendlessUser
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault
import com.example.androiddevfinalproject.databinding.ActivityRegistrationBinding

class RegistrationActivity: AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // retrieve any information from the intent using the extras keys
        val username = intent.getStringExtra(LoginActivity.EXTRA_USERNAME) ?: ""
        val password = intent.getStringExtra(LoginActivity.EXTRA_PASSWORD) ?: ""

        // prefill the username & password fields
        // for EditTexts, you actually have to use the setText functions
        binding.editTextRegistrationUsername.setText(username)
        binding.editTextTextPassword.setText(password)

        // register an account and send back the username & password
        // to the login activity to prefill those fields
        binding.buttonRegistrationRegister.setOnClickListener {
            val password = binding.editTextTextPassword.text.toString()
            val confirm = binding.editTextRegistrationConfirmPassword.text.toString()
            val username = binding.editTextRegistrationUsername.text.toString()
            val name = binding.editTextRegistrationName.text.toString()
            val email = binding.editTextRegistrationEmail.text.toString()

            if(password == confirm){


                // do not forget to call Backendless.initApp when your app initializes
                val user = BackendlessUser()
                user.setProperty("email", email)
                // dont forget username
                user.setProperty("name", name)
                user.setProperty("username", username)
                user.password = password

                Backendless.UserService.register(user, object : AsyncCallback<BackendlessUser?> {
                    override fun handleResponse(registeredUser: BackendlessUser?) {
                        // user has been registered and now can login
                        val intent = intent
                        intent.putExtra(LoginActivity.EXTRA_USERNAME, username)
                        intent.putExtra(LoginActivity.EXTRA_PASSWORD, password)
                        //setResult(RESULT_OK, intent)
                        val gameSelectionIntent = Intent(this@RegistrationActivity, GameSelectionActivity::class.java)
                        startActivity(gameSelectionIntent)
                        finish()
                    }

                    override fun handleFault(fault: BackendlessFault) {
                        // an error has occurred, the error code can be retrieved with fault.getCode()
                        Log.d("RegistrationActivity", "handleFault: ${fault.message}")
                    }
                })
            }


//            }
        }
    }
}