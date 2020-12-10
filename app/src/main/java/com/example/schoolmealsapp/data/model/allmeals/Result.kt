package com.example.schoolmealsapp.data.model.allmeals

import androidx.room.Entity

@Entity(tableName = "all_meals")
data class Result(
    val breakfast: Breakfast,
    val date: String,
    val dinner: Dinner,
    val lunch: Lunch
)