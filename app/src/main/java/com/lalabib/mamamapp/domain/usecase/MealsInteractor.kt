package com.lalabib.mamamapp.domain.usecase

import com.lalabib.mamamapp.data.local.entity.FavoriteEntity
import com.lalabib.mamamapp.data.remote.network.Result
import com.lalabib.mamamapp.domain.model.AreaMeals
import com.lalabib.mamamapp.domain.model.CategoryMeals
import com.lalabib.mamamapp.domain.model.DetailMeals
import com.lalabib.mamamapp.domain.repository.IMealsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MealsInteractor @Inject constructor(private val mealsRepository: IMealsRepository) :
    MealsUseCase {

    override fun getCategories(): Flow<Result<List<CategoryMeals>>> =
        mealsRepository.getCategories()

    override fun getAreas(): Flow<Result<List<AreaMeals>>> = mealsRepository.getAreas()
    override fun getMealsByCategory(category: String): Flow<Result<List<DetailMeals>>> =
        mealsRepository.getMealsByCategory(category)

    override fun getMealsByArea(area: String): Flow<Result<List<DetailMeals>>> =
        mealsRepository.getMealsByArea(area)

    override fun getMealsByName(name: String): Flow<Result<List<DetailMeals>>> =
        mealsRepository.getMealsByName(name)

    override fun getMealsById(id: String): Flow<Result<List<DetailMeals>>> =
        mealsRepository.getMealsById(id)

    override suspend fun insertFavorite(favorite: FavoriteEntity) =
        mealsRepository.insertFavorite(favorite)

    override fun getAllFavorites(): Flow<List<FavoriteEntity>> =
        mealsRepository.getAllFavorites()

    override fun checkMeal(id: String): Flow<List<FavoriteEntity>> =
        mealsRepository.checkMeal(id)

    override suspend fun deleteFavorite(favorite: FavoriteEntity) =
        mealsRepository.deleteFavorite(favorite)
}