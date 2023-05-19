package com.rgonzalez.cattracker.ui.list.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.rgonzalez.cattracker.data.model.CatModel
import com.rgonzalez.cattracker.databinding.CatItemBinding

class CatRecyclerViewHolder(private val binding: CatItemBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(cat: CatModel, clickListener: (CatModel) -> Unit) {
        binding.catNameText.text = cat.name
        binding.cardCatItem.setOnClickListener{
            clickListener(cat)
        }
    }
}