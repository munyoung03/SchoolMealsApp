package com.example.schoolmealsapp.data.model.meals

import androidx.room.Entity

@Entity(tableName = "meals")
data class MealsData(
    val breakfast: Breakfast,
    val dinner: Dinner,
    val lunch: Lunch,
    val time: String
)