package com.example.task7

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var dbHelper: DBHelper

    override fun onCreate(saved_content: Bundle?) {
        super.onCreate(saved_content)
        setContentView(R.layout.activity_main)

        dbHelper = DBHelper(this)

        val nameEditText = findViewById<TextInputEditText>(R.id.nameEditText)
        val emailEditText = findViewById<TextInputEditText>(R.id.emailEditText)
        val saveButton = findViewById<MaterialButton>(R.id.saveButton)
        val loadButton = findViewById<MaterialButton>(R.id.loadButton)
        val dataDisplayTextView = findViewById<TextView>(R.id.dataDisplayTextView)

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty()) {
                val dbExecution = dbHelper.saveUser(name, email)
                if (dbExecution != -1L) {
                    Toast.makeText(this, getString(R.string.msg_saved), Toast.LENGTH_SHORT).show()
                    nameEditText.text?.clear()
                    emailEditText.text?.clear()
                } else {
                    Toast.makeText(this, getString(R.string.msg_error), Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        loadButton.setOnClickListener {
            val user = dbHelper.getLatestUser()
            if (user != null) {
                dataDisplayTextView.text = getString(R.string.msg_loaded, user.first, user.second)
            } else {
                dataDisplayTextView.text = getString(R.string.msg_empty)
            }
        }
    }
}
