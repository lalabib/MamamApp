package com.lalabib.mamamapp.data.remote

import android.util.Log
import com.lalabib.mamamapp.data.local.LocalDataSource
import com.lalabib.mamamapp.data.local.entity.FavoriteEntity
import com.lalabib.mamamapp.data.remote.network.ApiService
import com.lalabib.mamamapp.domain.model.AreaMeals
import com.lalabib.mamamapp.domain.model.CategoryMeals
import com.lalabib.mamamapp.domain.repository.IMealsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.lalabib.mamamapp.data.remote.network.Result
import com.lalabib.mamamapp.domain.model.DetailMeals
import com.lalabib.mamamapp.utils.DataMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MealsRepository @Inject constructor(
    private val apiService: ApiService,
    private val localDataSource: LocalDataSource
) : IMealsRepository {

    override fun getCategories(): Flow<Result<List<CategoryMeals>>> {
        return flow {
            try {
                val response = apiService.getCategories()
                val dataArray = DataMapper.responseCategoryToDomain(response.meals)
                if (dataArray.isNotEmpty()) {
                    emit(Result.Success(dataArray))
                } else {
                    emit(Result.Loading)
                }
            } catch (e: Exception) {
                emit(Result.Error(e.message.toString()))
                Log.e("TAG", e.message.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getAreas(): Flow<Result<List<AreaMeals>>> {
        return flow {
            try {
                val response = apiService.getAreas()
                val dataArray = DataMapper.responseAreaToDomain(response.meals)
                if (dataArray.isNotEmpty()) {
                    emit(Result.Success(dataArray))
                } else {
                    emit(Result.Loading)
                }
            } catch (e: Exception) {
                emit(Result.Error(e.message.toString()))
                Log.e("TAG", e.message.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getMealsByCategory(category: String): Flow<Result<List<DetailMeals>>> {
        return flow {
            try {
                val response = apiService.getMealsByCategory(category)
                val dataArray = DataMapper.responseMealsToDomain(response.meals)
                if (dataArray.isNotEmpty()) {
                    emit(Result.Success(dataArray))
                } else {
                    emit(Result.Loading)
                }
            } catch (e: Exception) {
                emit(Result.Error(e.message.toString()))
                Log.e("TAG", e.message.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getMealsByArea(area: String): Flow<Result<List<DetailMeals>>> {
        return flow {
            try {
                val response = apiService.getMealsByArea(area)
                val dataArray = DataMapper.responseMealsToDomain(response.meals)
                if (dataArray.isNotEmpty()) {
                    emit(Result.Success(dataArray))
                } else {
                    emit(Result.Loading)
                }
            } catch (e: Exception) {
                emit(Result.Error(e.message.toString()))
                Log.e("TAG", e.message.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getMealsByName(name: String): Flow<Result<List<DetailMeals>>> {
        return flow {
            try {
                val response = apiService.getMealsByName(name)
                val dataArray = DataMapper.responseMealsToDomain(response.meals)
                if (dataArray.isNotEmpty()) {
                    emit(Result.Success(dataArray))
                } else {
                    emit(Result.Loading)
                }
            } catch (e: Exception) {
                emit(Result.Error(e.message.toString()))
                Log.e("TAG", e.message.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getMealsById(id: String): Flow<Result<List<DetailMeals>>> {
        return flow {
            try {
                val response = apiService.getMealsById(id)
                val data = DataMapper.responseMealsToDomain(response.meals)
                if (data.isNotEmpty()) {
                    emit(Result.Success(data))
                } else {
                    emit(Result.Loading)
                }
            } catch (e: Exception) {
                emit(Result.Error(e.message.toString()))
                Log.e("TAG", e.message.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun insertFavorite(favorite: FavoriteEntity) =
        localDataSource.insertFavorite(favorite)

    override fun getAllFavorites(): Flow<List<FavoriteEntity>> = localDataSource.getAllFavorites()

    override fun checkMeal(id: String): Flow<List<FavoriteEntity>>  = localDataSource.checkMeal(id)

    override suspend fun deleteFavorite(favorite: FavoriteEntity) = localDataSource.deleteFavorite(favorite)
}