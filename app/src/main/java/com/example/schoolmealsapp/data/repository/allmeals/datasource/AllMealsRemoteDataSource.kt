package com.example.schoolmealsapp.data.repository.allmeals.datasource

import com.example.schoolmealsapp.data.model.allmeals.AllMealsData
import retrofit2.Response

interface AllMealsRemoteDataSource {
    suspend fun getAllMeals(
        adCode: String,
        scCode: String,
        start: String,
        end: String,
    ): Response<AllMealsData>
}