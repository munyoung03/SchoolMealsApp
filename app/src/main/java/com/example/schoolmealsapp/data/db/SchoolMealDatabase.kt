package com.example.schoolmealsapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.schoolmealsapp.data.model.allmeals.AllMealsData
import com.example.schoolmealsapp.data.model.meals.MealsData
import com.example.schoolmealsapp.data.model.schoolname.SchoolNameData

@Database(entities = [SchoolNameData::class, MealsData::class, AllMealsData::class], version = 1, exportSchema = false)
abstract class SchoolMealDatabase : RoomDatabase(){
    abstract fun schoolNameDao(): SchoolNameDao
    abstract fun mealsDao(): MealsDao
    abstract fun allMealsDao(): AllMealsDao
    companion object{
        @Volatile
        private var INSTANCE : SchoolMealDatabase? = null
        fun getInstance(context: Context):SchoolMealDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null)
                {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SchoolMealDatabase::class.java,
                        "meals_data_base"
                    ).build()
                }
                return instance
            }
        }
    }
}