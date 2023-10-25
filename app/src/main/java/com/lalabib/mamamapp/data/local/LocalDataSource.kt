package com.lalabib.mamamapp.data.local

import com.lalabib.mamamapp.data.local.entity.FavoriteEntity
import com.lalabib.mamamapp.data.local.room.MealFavoriteDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val mealsDao: MealFavoriteDao) {
    suspend fun insertFavorite(favorite: FavoriteEntity) = mealsDao.insertFavorite(favorite)

    fun getAllFavorites(): Flow<List<FavoriteEntity>> = mealsDao.getAllFavorites()

    fun checkMeal(id: String): Flow<List<FavoriteEntity>> = mealsDao.checkMeal(id)

    suspend fun deleteFavorite(favorite: FavoriteEntity) = mealsDao.deleteFavorite(favorite)

}