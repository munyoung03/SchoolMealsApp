package com.example.schoolmealsapp.data.repository.allmeals.datasourcelmpl

import com.example.schoolmealsapp.data.db.AllMealsDao
import com.example.schoolmealsapp.data.model.allmeals.AllMeals
import com.example.schoolmealsapp.data.model.allmeals.AllMealsData
import com.example.schoolmealsapp.data.repository.allmeals.datasource.AllMealsLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllMealsLocalDataSourceImpl(private val allMealsDao: AllMealsDao) : AllMealsLocalDataSource {
    override suspend fun getAllMealsFromDB(): List<AllMeals> = allMealsDao.getAllMeals()

    override suspend fun saveAllMealsToDB(allMeals: List<AllMeals>) {
        CoroutineScope(Dispatchers.IO).launch {
            allMealsDao.saveAllMeals(allMeals)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            allMealsDao.deleteAllAllMeals()
        }
    }
}