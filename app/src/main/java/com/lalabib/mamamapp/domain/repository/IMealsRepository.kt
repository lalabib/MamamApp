package com.lalabib.mamamapp.domain.repository

import com.lalabib.mamamapp.data.local.entity.FavoriteEntity
import com.lalabib.mamamapp.data.remote.network.Result
import com.lalabib.mamamapp.domain.model.AreaMeals
import com.lalabib.mamamapp.domain.model.CategoryMeals
import com.lalabib.mamamapp.domain.model.DetailMeals
import kotlinx.coroutines.flow.Flow

interface IMealsRepository {

    fun getCategories(): Flow<Result<List<CategoryMeals>>>

    fun getAreas(): Flow<Result<List<AreaMeals>>>

    fun getMealsByCategory(category: String): Flow<Result<List<DetailMeals>>>

    fun getMealsByArea(area: String): Flow<Result<List<DetailMeals>>>

    fun getMealsByName(name: String): Flow<Result<List<DetailMeals>>>

    fun getMealsById(id: String): Flow<Result<List<DetailMeals>>>

    suspend fun insertFavorite(favorite: FavoriteEntity)

    fun getAllFavorites(): Flow<List<FavoriteEntity>>

    fun checkMeal(id: String): Flow<List<FavoriteEntity>>

    suspend fun deleteFavorite(favorite: FavoriteEntity)
}