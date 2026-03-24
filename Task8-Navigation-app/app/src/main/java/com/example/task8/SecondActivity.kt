package com.example.task8

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class SecondActivity : AppCompatActivity() {

    override fun onCreate(saved_content: Bundle?) {
        super.onCreate(saved_content)
        setContentView(R.layout.activity_second)

        val btnBack = findViewById<MaterialButton>(R.id.btnBack)

        btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun finish() {
        super.finish()
        // Apply custom transition animation when closing activity
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    // Handle back button transition
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        // Applying transition here as well if needed, although finish() covers it.
        // On newer Android versions, onBackPressedDispatcher is preferred.
    }
}
