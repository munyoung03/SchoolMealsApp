package com.example.schoolmealsapp.data.repository.allmeals.datasourcelmpl

import com.example.schoolmealsapp.data.api.MealsService
import com.example.schoolmealsapp.data.model.allmeals.AllMealsData
import com.example.schoolmealsapp.data.repository.allmeals.datasource.AllMealsRemoteDataSource
import retrofit2.Response

class AllMealsRemoteDataSourceImpl(
    private val mealsService: MealsService,

    ) :
    AllMealsRemoteDataSource {
    override suspend fun getAllMeals(
        adCode: String,
        scCode: String,
        start: String,
        end: String,
    ): Response<AllMealsData> = mealsService.getAllMeals(adCode, scCode, start, end)

}