package com.example.schoolmealsapp.data.repository.meal.datasource

import com.example.schoolmealsapp.data.model.meals.MealsData
import retrofit2.Response

interface MealRemoteDataSource {
    suspend fun getMeal(): Response<MealsData>
}