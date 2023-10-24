package com.lalabib.mamamapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class MealsListResponse (
    @field:SerializedName("meals")
    val meals: List<MealsResponse>
)

data class MealsResponse(
    @field:SerializedName("idMeal")
    val idMeal: String,

    @field:SerializedName("strMeal")
    val strMeal: String,

    @field:SerializedName("strMealThumb")
    val strMealThumb: String
)