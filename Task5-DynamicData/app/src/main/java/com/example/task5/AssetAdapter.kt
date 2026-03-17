package com.example.task5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AssetAdapter(private val assetList: List<IntelligenceAsset>) :
    RecyclerView.Adapter<AssetAdapter.AssetViewHolder>() {

    class AssetViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameText: TextView = view.findViewById(R.id.itemName)
        val descriptionText: TextView = view.findViewById(R.id.itemDescription)
        val typeText: TextView = view.findViewById(R.id.itemType)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_data, parent, false)
        return AssetViewHolder(view)
    }

    override fun onBindViewHolder(holder: AssetViewHolder, position: Int) {
        val asset = assetList[position]
        holder.nameText.text = asset.name
        holder.descriptionText.text = asset.description
        holder.typeText.text = "CATEGORY: ${asset.type.uppercase()}"
    }

    override fun getItemCount() = assetList.size
}
