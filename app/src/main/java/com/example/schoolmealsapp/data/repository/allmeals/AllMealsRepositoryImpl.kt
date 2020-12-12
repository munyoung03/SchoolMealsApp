package com.example.schoolmealsapp.data.repository.allmeals

import android.util.Log
import com.example.schoolmealsapp.data.model.allmeals.AllMeals
import com.example.schoolmealsapp.data.repository.allmeals.datasource.AllMealsCacheDataSource
import com.example.schoolmealsapp.data.repository.allmeals.datasource.AllMealsLocalDataSource
import com.example.schoolmealsapp.data.repository.allmeals.datasource.AllMealsRemoteDataSource
import com.example.schoolmealsapp.domain.repository.AllMealsRepository
import java.lang.Exception

class AllMealsRepositoryImpl(
    private val allMealsLocalDataSource: AllMealsLocalDataSource,
    private val allMealsRemoteDataSource: AllMealsRemoteDataSource,
    private val allMealsCacheDataSource: AllMealsCacheDataSource
) : AllMealsRepository{
    override suspend fun getAllMeals(): List<AllMeals> {
       return getAllMealsFromCache()
    }

    suspend fun getAllMealsFromAPI() : List<AllMeals> {
        lateinit var allMealsList : List<AllMeals>
        try{
            val response = allMealsRemoteDataSource.getAllMeals()
            val body = response.body()
            if(body != null){
                allMealsList = body.allMeals
            }
        }catch (exception : Exception){
            Log.d("TAG", exception.message.toString())
        }
        return allMealsList
    }

    suspend fun getAllMealsFromDB() : List<AllMeals> {
        lateinit var allMealsList : List<AllMeals>
        try{
            allMealsList = allMealsLocalDataSource.getAllMealsFromDB()

        }catch (exception : Exception){
            Log.d("TAG", exception.message.toString())
        }
        if(allMealsList.size > 0){
            return allMealsList
        }else{
            allMealsList = getAllMealsFromAPI()
            allMealsLocalDataSource.saveAllMealsToDB(allMealsList)
        }
        return allMealsList
    }

    suspend fun getAllMealsFromCache() : List<AllMeals> {
        lateinit var allMealsList : List<AllMeals>
        try{
            allMealsList = allMealsCacheDataSource.getAllMealsFromCache()

        }catch (exception : Exception){
            Log.d("TAG", exception.message.toString())
        }
        if(allMealsList.size > 0){
            return allMealsList
        }else{
            allMealsList = getAllMealsFromCache()
            allMealsCacheDataSource.saveAllMealsToCache(allMealsList)
        }
        return allMealsList
    }

}