package com.lalabib.mamamapp.utils

import com.lalabib.mamamapp.data.remote.response.AreaResponse
import com.lalabib.mamamapp.data.remote.response.CategoryResponse
import com.lalabib.mamamapp.data.remote.response.MealsResponse
import com.lalabib.mamamapp.domain.model.AreaMeals
import com.lalabib.mamamapp.domain.model.CategoryMeals
import com.lalabib.mamamapp.domain.model.Meals

object DataMapper {

    fun responseCategoryToDomain(response: List<CategoryResponse>) : List<CategoryMeals> {
        return response.map {
            CategoryMeals(
                strCategory = it.strCategory
            )
        }
    }

    fun responseAreaToDomain(response: List<AreaResponse>) : List<AreaMeals> {
        return response.map {
            AreaMeals(
                strArea = it.strArea
            )
        }
    }

    fun responseMealsToDomain(response: List<MealsResponse>) : List<Meals> {
        return response.map {
            Meals(
                idMeal = it.idMeal,
                strMeal = it.strMeal,
                strMealThumb = it.strMealThumb
            )
        }
    }
}