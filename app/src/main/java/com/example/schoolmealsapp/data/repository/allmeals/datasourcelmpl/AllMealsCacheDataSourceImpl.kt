package com.example.schoolmealsapp.data.repository.allmeals.datasourcelmpl

import com.example.schoolmealsapp.data.model.allmeals.AllMeals
import com.example.schoolmealsapp.data.model.allmeals.AllMealsData
import com.example.schoolmealsapp.data.repository.allmeals.datasource.AllMealsCacheDataSource

class AllMealsCacheDataSourceImpl : AllMealsCacheDataSource {

    private var allMealsList = ArrayList<AllMeals>()
    override suspend fun getAllMealsFromCache(): List<AllMeals> {
        return allMealsList
    }

    override suspend fun saveAllMealsToCache(allMeals: List<AllMeals>) {
        allMealsList.clear()
        allMealsList = ArrayList(allMeals)
    }


}