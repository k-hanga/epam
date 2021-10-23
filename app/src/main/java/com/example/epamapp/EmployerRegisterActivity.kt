package com.example.epamapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class EmployerRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employer_register)

        val etEmployerName = findViewById<EditText>(R.id.etEmployerName)
        val etEmailAddress = findViewById<EditText>(R.id.etEmailAddress)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etRePassword = findViewById<EditText>(R.id.etRePassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val btnBack = findViewById<Button>(R.id.btnBack)

        btnRegister.setOnClickListener {
            if (etEmployerName.text.toString().isEmpty()) {
                etEmployerName.requestFocus()
                etEmployerName.error = "Enter a company/employer name"
                return@setOnClickListener
            }
            if (etEmailAddress.text.toString().isEmpty()) {
                etEmailAddress.requestFocus()
                etEmailAddress.error = "Enter a valid email address"
                return@setOnClickListener
            }
            if (etPassword.text.toString().isEmpty()) {
                etPassword.requestFocus()
                etPassword.error = "Enter your password"
                return@setOnClickListener
            }
            if (etPassword.text.toString() != etRePassword.text.toString()) {
                etRePassword.requestFocus()
                etRePassword.error = "Not matching passwords!"
                return@setOnClickListener
            }
            Toast.makeText(applicationContext, "Successful registry", Toast.LENGTH_SHORT).show();
            intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }
        btnBack.setOnClickListener {
            intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}