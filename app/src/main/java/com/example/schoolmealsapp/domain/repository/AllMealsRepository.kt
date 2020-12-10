package com.example.schoolmealsapp.domain.repository

import com.example.schoolmealsapp.data.model.allmeals.AllMeals

interface AllMealsRepository {
    suspend fun getAllMeals() : List<AllMeals>
}