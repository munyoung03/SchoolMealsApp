package com.example.schoolmealsapp.data.repository.allmeals.datasource

import com.example.schoolmealsapp.data.model.allmeals.AllMeals

interface AllMealsLocalDataSource {
    suspend fun getAllMealsFromDB() : List<AllMeals>
    suspend fun saveAllMealsToDB(allMeals:List<AllMeals>)
    suspend fun clearAll()
}