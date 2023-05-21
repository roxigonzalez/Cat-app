package com.rgonzalez.cattracker.ui.list.recyclerview

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.rgonzalez.cattracker.data.model.CatModel
import com.rgonzalez.cattracker.databinding.CatItemBinding
import com.rgonzalez.cattracker.ui.detail.CatViewModel

class CatRecyclerViewHolder(private val binding: CatItemBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(cat: CatModel, clickListener: (CatModel) -> Unit) {
        binding.catNameText.text = cat.name
        binding.cardCatItem.setOnClickListener{
            clickListener(cat)
        }
    }
}