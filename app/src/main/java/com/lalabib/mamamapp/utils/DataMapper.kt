package com.lalabib.mamamapp.utils

import com.lalabib.mamamapp.data.remote.response.AreaResponse
import com.lalabib.mamamapp.data.remote.response.CategoryResponse
import com.lalabib.mamamapp.data.remote.response.DetailMealsResponse
import com.lalabib.mamamapp.domain.model.AreaMeals
import com.lalabib.mamamapp.domain.model.CategoryMeals
import com.lalabib.mamamapp.domain.model.DetailMeals

object DataMapper {

    fun responseCategoryToDomain(response: List<CategoryResponse>): List<CategoryMeals> {
        return response.map {
            CategoryMeals(
                strCategory = it.strCategory
            )
        }
    }

    fun responseAreaToDomain(response: List<AreaResponse>): List<AreaMeals> {
        return response.map {
            AreaMeals(
                strArea = it.strArea
            )
        }
    }

    fun responseMealsToDomain(response: List<DetailMealsResponse>): List<DetailMeals> {
        return response.map {
            DetailMeals(
                it.idMeal,
                it.strMeal,
                it.strMealThumb,
                it.strCategory,
                it.strArea,
                it.strInstructions,
                it.strYoutube,
                it.strIngredient1,
                it.strIngredient2,
                it.strIngredient3,
                it.strIngredient4,
                it.strIngredient5,
                it.strIngredient6,
                it.strIngredient7,
                it.strIngredient8,
                it.strIngredient9,
                it.strIngredient10,
                it.strIngredient11,
                it.strIngredient12,
                it.strIngredient13,
                it.strIngredient14,
                it.strIngredient15,
                it.strIngredient16,
                it.strIngredient17,
                it.strIngredient18,
                it.strIngredient19,
                it.strIngredient20,
                it.strMeasure1,
                it.strMeasure2,
                it.strMeasure3,
                it.strMeasure4,
                it.strMeasure5,
                it.strMeasure6,
                it.strMeasure7,
                it.strMeasure8,
                it.strMeasure9,
                it.strMeasure10,
                it.strMeasure11,
                it.strMeasure12,
                it.strMeasure13,
                it.strMeasure14,
                it.strMeasure15,
                it.strMeasure16,
                it.strMeasure17,
                it.strMeasure18,
                it.strMeasure19,
                it.strMeasure20,
            )
        }
    }
}