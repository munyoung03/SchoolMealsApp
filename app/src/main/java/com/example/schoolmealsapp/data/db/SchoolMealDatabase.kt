package com.example.schoolmealsapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.schoolmealsapp.data.model.allmeals.*
import com.example.schoolmealsapp.data.model.schoolname.Sc
@TypeConverters(BreakfastConverter::class, LunchConverter::class, DinnerConverter::class)
@Database(entities = [Sc::class, AllMeals::class], version = 2, exportSchema = false)
abstract class SchoolMealDatabase : RoomDatabase(){
    abstract fun schoolNameDao(): SchoolNameDao
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
                    )
                        .fallbackToDestructiveMigration().build()
                }
                return instance
            }
        }
    }
}