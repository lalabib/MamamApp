package com.lalabib.mamamapp.domain.repository

import com.lalabib.mamamapp.data.remote.network.Result
import com.lalabib.mamamapp.domain.model.AreaMeals
import com.lalabib.mamamapp.domain.model.CategoryMeals
import com.lalabib.mamamapp.domain.model.Meals
import kotlinx.coroutines.flow.Flow

interface IMealsRepository {

    fun getCategories(): Flow<Result<List<CategoryMeals>>>

    fun getAreas(): Flow<Result<List<AreaMeals>>>

    fun getMealsByCategory(category: String): Flow<Result<List<Meals>>>

    fun getMealsByArea(area: String): Flow<Result<List<Meals>>>
}