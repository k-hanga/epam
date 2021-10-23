package com.example.epamapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ChoiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)

        val btnEmployer = findViewById<Button>(R.id.btnEmployer)
        val btnJobseeker = findViewById<Button>(R.id.btnJobseeker)

        btnEmployer.setOnClickListener {
            intent = Intent(applicationContext, EmployerRegisterActivity::class.java)
            startActivity(intent)
        }

        btnJobseeker.setOnClickListener {
            intent = Intent(applicationContext, SeekerRegisterActivity::class.java)
            startActivity(intent)
        }
    }
}