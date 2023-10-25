package com.lalabib.mamamapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.lalabib.mamamapp.domain.usecase.MealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val mealsUseCase: MealsUseCase) : ViewModel() {

    fun getDetailMeals(id: String) = mealsUseCase.getMealsById(id).asLiveData()
}