package com.example.schoolmealsapp.data.repository.meal.datasourcelmpl

import com.example.schoolmealsapp.data.model.meals.MealsData
import com.example.schoolmealsapp.data.repository.meal.datasource.MealCacheDataSource

class MealCacheDataSourceImpl : MealCacheDataSource {

    private lateinit var MealList : MealsData

    override suspend fun getMealFromCache(): MealsData {
        return MealList
    }

    override suspend fun saveMealToCache(Meal: MealsData) {
        MealList = Meal
    }

}