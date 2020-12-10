package com.example.schoolmealsapp.data.db

import androidx.room.Database
import com.example.schoolmealsapp.data.model.allmeals.AllMealsData
import com.example.schoolmealsapp.data.model.meals.MealsData
import com.example.schoolmealsapp.data.model.schoolname.SchoolNameData

@Database(entities = [SchoolNameData::class, MealsData::class, AllMealsData::class], version = 1, exportSchema = false)
abstract class SchoolMealDatabase {
    abstract fun schoolNameDao(): SchoolNameDao
    abstract fun mealsDao(): MealsDao
    abstract fun allMealsDao(): AllMealsDao
}