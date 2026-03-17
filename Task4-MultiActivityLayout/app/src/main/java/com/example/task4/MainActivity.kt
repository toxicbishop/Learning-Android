package com.example.task4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameInput: EditText = findViewById(R.id.nameEditText)
        val startBtn: Button = findViewById(R.id.getStartedButton)

        startBtn.setOnClickListener {
            val name = nameInput.text.toString()
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("user_name", if (name.isEmpty()) "Intern" else name)
            startActivity(intent)
        }
    }
}
