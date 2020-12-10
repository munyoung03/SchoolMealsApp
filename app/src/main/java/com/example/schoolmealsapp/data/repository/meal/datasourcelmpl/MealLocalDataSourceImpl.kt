package com.example.schoolmealsapp.data.repository.meal.datasourcelmpl

import com.example.schoolmealsapp.data.db.MealsDao
import com.example.schoolmealsapp.data.model.meals.MealsData
import com.example.schoolmealsapp.data.repository.meal.datasource.MealLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealLocalDataSourceImpl(private val mealDao: MealsDao) : MealLocalDataSource {
    override suspend fun getMealFromDB(): MealsData = mealDao.getMeals()

    override suspend fun saveMealToDB(Meals: MealsData) {
        CoroutineScope(Dispatchers.IO).launch {
            mealDao.saveMeals(Meals)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            mealDao.deleteAllMeals()
        }
    }
}