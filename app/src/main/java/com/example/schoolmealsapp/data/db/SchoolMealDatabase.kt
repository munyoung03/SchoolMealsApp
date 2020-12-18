package com.example.schoolmealsapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.schoolmealsapp.data.model.allmeals.*
import com.example.schoolmealsapp.data.model.schoolname.Sc
@TypeConverters(BreakfastConverter::class, LunchConverter::class, DinnerConverter::class)
@Database(entities = [Sc::class, AllMeals::class], version = 2, exportSchema = false)
abstract class SchoolMealDatabase : RoomDatabase(){
    abstract fun schoolNameDao(): SchoolNameDao
    abstract fun allMealsDao(): AllMealsDao
}