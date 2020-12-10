package com.example.schoolmealsapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schoolmealsapp.data.model.allmeals.AllMeals
import com.example.schoolmealsapp.data.model.allmeals.AllMealsData

@Dao
interface AllMealsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllMeals(allMeals : List<AllMeals>)

    @Query("DELETE FROM all_meals")
    suspend fun deleteAllAllMeals()

    @Query("SELECT * FROM all_meals")
    suspend fun getAllMeals() : List<AllMeals>
}