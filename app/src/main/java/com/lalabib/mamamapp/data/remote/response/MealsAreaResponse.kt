package com.lalabib.mamamapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class MealsAreaResponse (
    @field:SerializedName("meals")
    val meals: List<AreaResponse>
)

data class AreaResponse (
    @field:SerializedName("strArea")
    val strArea: String
)