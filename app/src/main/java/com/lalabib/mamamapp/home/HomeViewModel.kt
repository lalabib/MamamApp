package com.lalabib.mamamapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.lalabib.mamamapp.domain.usecase.MealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val mealsUseCase: MealsUseCase) : ViewModel() {

    val getCategories = mealsUseCase.getCategories().asLiveData()

    val getAreas = mealsUseCase.getAreas().asLiveData()

    fun getMealsByCategory(category: String) = mealsUseCase.getMealsByCategory(category).asLiveData()

    fun getMealsByArea(area: String) = mealsUseCase.getMealsByArea(area).asLiveData()
}