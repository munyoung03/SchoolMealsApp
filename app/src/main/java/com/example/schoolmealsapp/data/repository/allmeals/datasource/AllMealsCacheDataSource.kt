package com.example.schoolmealsapp.data.repository.allmeals.datasource

import com.example.schoolmealsapp.data.model.allmeals.AllMeals
import com.example.schoolmealsapp.data.model.allmeals.AllMealsData

interface AllMealsCacheDataSource {
    suspend fun getAllMealsFromCache() : List<AllMeals>
    suspend fun saveAllMealsToCache(allMeals : List<AllMeals>)
}