package com.example.schoolmealsapp.data.model.allmeals

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class LunchConverter {
    @TypeConverter
    fun fromLunch(lunch : Lunch?) : String {
        if(lunch == null) return "null"
        val gson = Gson()
        val type =  object : TypeToken<Lunch>(){}.type
        return gson.toJson(lunch, type)
    }
    @TypeConverter
    fun toLunch(lunch : String) : Lunch {
        if(lunch == "null") return Lunch("", "", "")
        val gson = Gson()
        val type =  object : TypeToken<Lunch>(){}.type
        return gson.fromJson(lunch, type)
    }
}