package com.example.task4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val userName = intent.getStringExtra("user_name")
        val welcomeLabel: TextView = findViewById(R.id.welcomeText)
        welcomeLabel.text = "Welcome Back, $userName!"

        val profileBtn: Button = findViewById(R.id.profileButton)
        profileBtn.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("user_name", userName)
            startActivity(intent)
        }
    }
}
