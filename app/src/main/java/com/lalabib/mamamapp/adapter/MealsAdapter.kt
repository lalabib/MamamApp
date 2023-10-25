package com.lalabib.mamamapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lalabib.mamamapp.databinding.ItemListMealsBinding
import com.lalabib.mamamapp.domain.model.DetailMeals
import com.lalabib.mamamapp.utils.SharedObject.loadAvatar

class MealsAdapter(private val onItemClick: (DetailMeals) -> Unit) :
    ListAdapter<DetailMeals, MealsAdapter.ViewHolder>(MealsDiffUtil) {
    private object MealsDiffUtil : DiffUtil.ItemCallback<DetailMeals>() {
        override fun areItemsTheSame(oldItem: DetailMeals, newItem: DetailMeals): Boolean {
            return oldItem.idMeal == newItem.idMeal
        }

        override fun areContentsTheSame(oldItem: DetailMeals, newItem: DetailMeals): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListMealsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(onItemClick, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val meals = getItem(position)
        if (meals != null) {
            holder.bind(meals)
        }
    }

    class ViewHolder(
        private val onItemClick: (DetailMeals) -> Unit,
        private val binding: ItemListMealsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(meal: DetailMeals) {
            binding.apply {
                tvName.text = meal.strMeal
                loadAvatar(ivAvatar, meal.strMealThumb)
            }
            itemView.setOnClickListener { onItemClick(meal) }
        }
    }
}