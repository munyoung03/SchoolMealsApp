package com.example.schoolmealsapp.data.model.allmeals

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName

@Entity(tableName = "all_meals")
data class AllMeals(
    @PrimaryKey
    val date: String,
    @TypeConverters(BreakfastConverter::class)
    val breakfast: Breakfast,
    @TypeConverters(DinnerConverter::class)
    val dinner: Dinner,
    @TypeConverters(LunchConverter::class)
    val lunch: Lunch
)