package com.example.schoolmealsapp.data.model.allmeals

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class BreakfastConverter {
    @TypeConverter
    fun fromBreakfast(breakfast : Breakfast?) : String {
        if(breakfast == null) return "null"
        val gson = Gson()
        val type =  object : TypeToken<Breakfast>(){}.type
        return gson.toJson(breakfast, type)
    }
    @TypeConverter
    fun toBreakfast(breakfast : String) : Breakfast {
        if(breakfast == "null") return Breakfast("", "", "")
        val gson = Gson()
        val type =  object : TypeToken<Breakfast>(){}.type
        return gson.fromJson(breakfast, type)
    }
}