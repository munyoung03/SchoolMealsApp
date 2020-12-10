package com.example.schoolmealsapp.data.repository.meal.datasourcelmpl

import com.example.schoolmealsapp.data.api.MealsService
import com.example.schoolmealsapp.data.model.meals.MealsData
import com.example.schoolmealsapp.data.repository.meal.datasource.MealRemoteDataSource
import retrofit2.Response

class MealRemoteDataSourceImpl(
    private val mealsService: MealsService,
    private val adCode: String,
    private val scCode: String,
    private val time: String
) :
    MealRemoteDataSource {
    override suspend fun getMeal(): Response<MealsData> =
        mealsService.getMeals(adCode, scCode, time)
}