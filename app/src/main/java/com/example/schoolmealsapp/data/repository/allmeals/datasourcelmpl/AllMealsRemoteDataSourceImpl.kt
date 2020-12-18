package com.example.schoolmealsapp.data.repository.allmeals.datasourcelmpl

import androidx.room.PrimaryKey
import com.example.schoolmealsapp.data.api.MealsService
import com.example.schoolmealsapp.data.model.allmeals.AllMeals
import com.example.schoolmealsapp.data.model.allmeals.AllMealsData
import com.example.schoolmealsapp.data.repository.allmeals.datasource.AllMealsRemoteDataSource
import retrofit2.Response

class AllMealsRemoteDataSourceImpl(
    private val mealsService: MealsService,
    private val adCode: String,
    private val scCode: String,
    private val start: String,
    private val end: String,
) :
    AllMealsRemoteDataSource {
    override suspend fun getAllMeals(): Response<AllMealsData> = mealsService.getAllMeals(adCode, scCode, start, end)

}