package com.example.schoolmealsapp.domain.repository

import com.example.schoolmealsapp.data.model.meals.MealsData

interface MealRepository {
    suspend fun getMeal() : MealsData
}