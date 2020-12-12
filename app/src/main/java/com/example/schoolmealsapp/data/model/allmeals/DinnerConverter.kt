package com.example.schoolmealsapp.data.model.allmeals

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class DinnerConverter {
    @TypeConverter
    fun fromDinner(dinner : Dinner?) : String {
        if(dinner == null) return "null"
        val gson = Gson()
        val type =  object : TypeToken<Dinner>(){}.type
        return gson.toJson(dinner, type)
    }
    @TypeConverter
    fun toDinner(dinner : String) : Dinner {
        if(dinner == "null") return Dinner("", "", "")
        val gson = Gson()
        val type =  object : TypeToken<Dinner>(){}.type
        return gson.fromJson(dinner, type)
    }
}