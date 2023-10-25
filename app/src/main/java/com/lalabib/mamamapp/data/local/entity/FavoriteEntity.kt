package com.lalabib.mamamapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meals_entities")
data class FavoriteEntity (
    @PrimaryKey
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String,
)