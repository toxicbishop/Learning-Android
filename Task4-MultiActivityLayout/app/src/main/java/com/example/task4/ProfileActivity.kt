package com.example.task4

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val userName = intent.getStringExtra("user_name")
        val nameDisplay: TextView = findViewById(R.id.userNameDisplay)
        nameDisplay.text = userName

        val backBtn: Button = findViewById(R.id.backButton)
        backBtn.setOnClickListener {
            finish()
        }
    }
}
