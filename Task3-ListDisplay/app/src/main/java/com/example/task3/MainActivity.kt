package com.example.task3

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Static data to populate the list
        val intelligenceItems = arrayOf(
            "Predictive Analytics",
            "Natural Language Processing",
            "Computer Vision",
            "Neural Networks",
            "Machine Learning Models",
            "Data Extraction",
            "Automated Reasoning",
            "Deep Learning",
            "Speech Recognition",
            "Reinforcement Learning"
        )

        val listView: ListView = findViewById(R.id.itemsListView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, intelligenceItems)
        listView.adapter = adapter
    }
}
