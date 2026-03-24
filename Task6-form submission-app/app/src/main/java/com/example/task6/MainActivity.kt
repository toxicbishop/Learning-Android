package com.example.task6

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(saved_content: Bundle?) {
        super.onCreate(saved_content)
        setContentView(R.layout.activity_main)

        val nameEditText = findViewById<TextInputEditText>(R.id.nameEditText)
        val emailEditText = findViewById<TextInputEditText>(R.id.emailEditText)
        val submitButton = findViewById<MaterialButton>(R.id.submitButton)

        submitButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty()) {
                val message = getString(R.string.success_message, name, email)
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, getString(R.string.error_empty_fields), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
