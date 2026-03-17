package com.example.task5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Define dynamic data (Step 1 of Task 5)
        val assets = listOf(
            IntelligenceAsset("Predictive Analytics", "Historical data analysis to forecast future trends and outcomes.", "Analysis"),
            IntelligenceAsset("NLP Engine", "Real-time processing of human language for sentiment and context.", "Language"),
            IntelligenceAsset("Computer Vision", "Identifying objects and patterns in visual inputs with high accuracy.", "Vision"),
            IntelligenceAsset("Neural Optimizer", "Deep learning model refinement for edge device performance.", "Optimization"),
            IntelligenceAsset("Data Synthesizer", "Generating synthetic datasets for balanced model training.", "Generation"),
            IntelligenceAsset("Anomaly Detector", "Identifying outliers and security threats in network traffic.", "Security"),
            IntelligenceAsset("Reinforcement Learning", "Autonomous agent training through iterative reward systems.", "Learning")
        )

        // Setup RecyclerView (Step 2 of Task 5)
        val recyclerView: RecyclerView = findViewById(R.id.dynamicRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AssetAdapter(assets)
    }
}
