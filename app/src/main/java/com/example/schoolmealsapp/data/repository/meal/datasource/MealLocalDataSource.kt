package com.example.schoolmealsapp.data.repository.meal.datasource

import com.example.schoolmealsapp.data.model.meals.MealsData


interface MealLocalDataSource {
    suspend fun getMealFromDB() : MealsData
    suspend fun saveMealToDB(Meals:MealsData)
    suspend fun clearAll()
}