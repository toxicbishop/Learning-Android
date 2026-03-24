package com.example.task8

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(saved_content: Bundle?) {
        super.onCreate(saved_content)
        setContentView(R.layout.activity_main)

        val btnNext = findViewById<MaterialButton>(R.id.btnNext)

        btnNext.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            
            // Apply custom transition animation
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }
}
