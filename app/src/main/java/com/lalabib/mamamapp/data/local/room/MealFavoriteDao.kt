package com.lalabib.mamamapp.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lalabib.mamamapp.data.local.entity.FavoriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MealFavoriteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFavorite(favorite: FavoriteEntity)

    @Query("SELECT * FROM meals_entities")
    fun getAllFavorites(): Flow<List<FavoriteEntity>>

    @Query("SELECT * FROM meals_entities WHERE idMeal = :id")
    fun checkMeal(id: String): Flow<List<FavoriteEntity>>

    @Delete
    suspend fun deleteFavorite(favorite: FavoriteEntity)
}