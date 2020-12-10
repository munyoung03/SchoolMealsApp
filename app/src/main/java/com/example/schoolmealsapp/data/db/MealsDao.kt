package com.example.schoolmealsapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schoolmealsapp.data.model.meals.MealsData

@Dao
interface MealsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMeals(meals : List<MealsData>)

    @Query("DELETE FROM meals")
    suspend fun deleteAllMeals()

    @Query("SELECT * FROM meals")
    suspend fun getMeals() : List<MealsData>
}