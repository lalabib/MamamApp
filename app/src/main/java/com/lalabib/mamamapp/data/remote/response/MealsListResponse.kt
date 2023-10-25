package com.lalabib.mamamapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class MealsListResponse (
    @field:SerializedName("meals")
    val meals: List<DetailMealsResponse>
)