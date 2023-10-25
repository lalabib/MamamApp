package com.lalabib.mamamapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lalabib.mamamapp.data.local.entity.FavoriteEntity
import com.lalabib.mamamapp.databinding.ItemListMealsBinding
import com.lalabib.mamamapp.utils.SharedObject.loadAvatar

class FavoriteMealsAdapter(private val onItemClick: (FavoriteEntity) -> Unit) :
    ListAdapter<FavoriteEntity, FavoriteMealsAdapter.ViewHolder>(FavMealDiffUtil) {
    private object FavMealDiffUtil : DiffUtil.ItemCallback<FavoriteEntity>() {
        override fun areItemsTheSame(oldItem: FavoriteEntity, newItem: FavoriteEntity): Boolean {
            return oldItem.idMeal == newItem.idMeal
        }

        override fun areContentsTheSame(oldItem: FavoriteEntity, newItem: FavoriteEntity): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListMealsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(onItemClick, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val favMeals = getItem(position)
        if (favMeals!= null) {
            holder.bind(favMeals)
        }
    }

    class ViewHolder(
        private val onItemClick: (FavoriteEntity) -> Unit,
        private val binding: ItemListMealsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(favMeal: FavoriteEntity) {
            binding.apply {
                tvName.text = favMeal.strMeal
                loadAvatar(ivAvatar, favMeal.strMealThumb)
            }
            itemView.setOnClickListener { onItemClick(favMeal) }
        }
    }
}