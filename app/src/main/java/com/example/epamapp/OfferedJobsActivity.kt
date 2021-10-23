package com.example.epamapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class OfferedJobsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offered_jobs)

        val rwOfferedList = findViewById<RecyclerView>(R.id.rwOfferedList)
    }
}