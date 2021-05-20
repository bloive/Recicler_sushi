package com.example.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler.databinding.ItemDrinkBinding
import com.example.recycler.databinding.ItemFoodBinding

class RecyclerAdapter (private val items: MutableList<FoodModel>, private val ItemListener: ItemListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object {
        private const val FOOD_VIEW_TYPE = 1
        private const val DRINK_VIEW_TYPE = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == FOOD_VIEW_TYPE) {
            FoodViewHolder(ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        } else {
            DrinkViewHolder(ItemDrinkBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is FoodViewHolder -> holder.bind()
            is DrinkViewHolder -> holder.bind()
        }
    }

    override fun getItemCount() = items.size

    inner class FoodViewHolder(private val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener, View.OnLongClickListener {
        private lateinit var model: FoodModel
        fun bind() {
            model = items[adapterPosition]
            binding.icon.setImageResource(model.icon?:R.drawable.ic_logo)
            binding.itemTitle.text = model.title
            binding.itemDescript.text = model.descript
            binding.root.setOnClickListener(this)
            binding.root.setOnLongClickListener(this)
        }
        override fun onClick ( v: View?) {
            ItemListener.ItemOnClick(adapterPosition)
        }

        override fun onLongClick ( v: View?) : Boolean{
            ItemListener.ItemOnLongClick(adapterPosition)
            return true
        }
    }

    inner class DrinkViewHolder(private val binding: ItemDrinkBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener, View.OnLongClickListener  {
        private lateinit var model: FoodModel
        fun bind() {
            model = items[adapterPosition]
            binding.icon.setImageResource(model.icon?:R.drawable.ic_sake)
            binding.itemTitle.text = model.title
            binding.root.setOnClickListener(this)
            binding.root.setOnLongClickListener(this)
        }
        override fun onClick ( v: View?) {
            ItemListener.ItemOnClick(adapterPosition)
        }

        override fun onLongClick ( v: View?): Boolean {
            ItemListener.ItemOnLongClick(adapterPosition)
            return true
        }
    }

    override fun getItemViewType(position: Int): Int {
        val model = items[position]
        return if (model.descript == null)
            DRINK_VIEW_TYPE
        else
            FOOD_VIEW_TYPE
    }
}