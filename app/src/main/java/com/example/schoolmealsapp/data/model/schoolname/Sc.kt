package com.example.schoolmealsapp.data.model.schoolname

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "school_name")
data class Sc(
    @PrimaryKey
    val a_sc_code: String,
    val address: String,
    val sc_code: String,
    val school_name: String
)