package com.lalabib.mamamapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class MealsCategoryResponse (
    @field:SerializedName("meals")
    val meals: List<CategoryResponse>
)

data class CategoryResponse (
    @field:SerializedName("strCategory")
    val strCategory: String
)