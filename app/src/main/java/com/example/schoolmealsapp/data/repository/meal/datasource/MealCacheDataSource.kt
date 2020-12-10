package com.example.schoolmealsapp.data.repository.meal.datasource

import com.example.schoolmealsapp.data.model.meals.MealsData


interface MealCacheDataSource {
    suspend fun getMealFromCache() : MealsData
    suspend fun saveMealToCache(Meal : MealsData)
}