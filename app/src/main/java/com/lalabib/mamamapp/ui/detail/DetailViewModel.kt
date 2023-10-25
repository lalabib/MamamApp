package com.lalabib.mamamapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.lalabib.mamamapp.data.local.entity.FavoriteEntity
import com.lalabib.mamamapp.domain.usecase.MealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val mealsUseCase: MealsUseCase) : ViewModel() {

    fun getDetailMeals(id: String) = mealsUseCase.getMealsById(id).asLiveData()

    fun insertFavorite(favorite: FavoriteEntity) {
        viewModelScope.launch {
            mealsUseCase.insertFavorite(favorite)
        }
    }
    fun checkMeal(id: String) = mealsUseCase.checkMeal(id).asLiveData()

    fun deleteFavorite(favorite: FavoriteEntity) {
        viewModelScope.launch {
            mealsUseCase.deleteFavorite(favorite)
        }
    }
}