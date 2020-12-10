package com.example.schoolmealsapp.data.model.schoolname

import androidx.room.Entity

@Entity(tableName = "school_name")
data class SchoolNameData(
    val `data`: Data,
    val message: String,
    val status: Int
)