package com.lalabib.mamamapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lalabib.mamamapp.databinding.ItemListMealsBinding
import com.lalabib.mamamapp.domain.model.Meals
import com.lalabib.mamamapp.utils.SharedObject.loadAvatar

class MealsAdapter : ListAdapter<Meals, MealsAdapter.ViewHolder>(MealsDiffUtil) {
    private object MealsDiffUtil : DiffUtil.ItemCallback<Meals>() {
        override fun areItemsTheSame(oldItem: Meals, newItem: Meals): Boolean {
            return oldItem.idMeal == newItem.idMeal
        }

        override fun areContentsTheSame(oldItem: Meals, newItem: Meals): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListMealsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val meals = getItem(position)
        if (meals != null) {
            holder.bind(meals)
        }
    }

    class ViewHolder(
        private val binding: ItemListMealsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(meal: Meals) {
            binding.apply {
                tvName.text = meal.strMeal
                loadAvatar(ivAvatar, meal.strMealThumb)
            }
        }
    }
}