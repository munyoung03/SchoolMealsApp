package com.example.schoolmealsapp.data.model.allmeals

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "all_meals")
data class AllMeals(
    val breakfast: Breakfast,
    val date: String,
    val dinner: Dinner,
    val lunch: Lunch
)