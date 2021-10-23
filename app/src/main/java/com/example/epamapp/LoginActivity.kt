package com.example.epamapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmailAddress = findViewById<EditText>(R.id.etEmailAddress)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            intent = Intent(applicationContext, ChoiceActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            if (etEmailAddress.text.toString().isEmpty()) {
                etEmailAddress.requestFocus()
                etEmailAddress.error = "Please enter your email address"
            }
            if (etPassword.text.toString().isEmpty()) {
                etPassword.requestFocus()
                etPassword.error = "Please enter your password"
            }
            if (etEmailAddress.text.toString().contains("jobseeker")) {
                intent = Intent(applicationContext, SeekJobsActivity::class.java)
                startActivity(intent)

            } else if (etEmailAddress.text.toString().contains("employer")) {
                intent = Intent(applicationContext, OfferedJobsActivity::class.java)
                startActivity(intent)
            }
        }

    }
}