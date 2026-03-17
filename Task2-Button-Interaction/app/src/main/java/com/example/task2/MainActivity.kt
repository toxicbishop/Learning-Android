package com.example.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.interactionButton)
        btn.setOnClickListener {
            Toast.makeText(this, "Hello! I am Task 2.", Toast.LENGTH_SHORT).show()
        }
    }
}
