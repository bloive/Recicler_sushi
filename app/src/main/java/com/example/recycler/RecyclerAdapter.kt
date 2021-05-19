package com.example.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler.databinding.ItemBinding

class RecyclerAdapter (private val items: MutableList<Model>) : RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = items.size

    inner class ItemViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private lateinit var model: Model
        fun bind() {
            model = items[adapterPosition]
            binding.icon.setImageResource(model.icon)
            binding.itemTitle.text = model.title
            binding.itemDescript.text = model.descript
        }
    }
}