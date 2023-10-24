package com.lalabib.mamamapp.domain.usecase

import com.lalabib.mamamapp.data.remote.network.Result
import com.lalabib.mamamapp.domain.model.AreaMeals
import com.lalabib.mamamapp.domain.model.CategoryMeals
import com.lalabib.mamamapp.domain.model.Meals
import com.lalabib.mamamapp.domain.repository.IMealsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MealsInteractor @Inject constructor(private val mealsRepository: IMealsRepository) :
    MealsUseCase {
    override fun getCategories(): Flow<Result<List<CategoryMeals>>> =
        mealsRepository.getCategories()

    override fun getAreas(): Flow<Result<List<AreaMeals>>> = mealsRepository.getAreas()
    override fun getMealsByCategory(category: String): Flow<Result<List<Meals>>> =
        mealsRepository.getMealsByCategory(category)

    override fun getMealsByArea(area: String): Flow<Result<List<Meals>>> =
        mealsRepository.getMealsByArea(area)
}