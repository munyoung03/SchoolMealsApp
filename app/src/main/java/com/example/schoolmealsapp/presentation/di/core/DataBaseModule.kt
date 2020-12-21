package com.example.schoolmealsapp.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.schoolmealsapp.data.db.AllMealsDao
import com.example.schoolmealsapp.data.db.SchoolMealDatabase
import com.example.schoolmealsapp.data.db.SchoolNameDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideSchoolMealDataBase(context: Context) : SchoolMealDatabase{
        return Room.databaseBuilder(context, SchoolMealDatabase::class.java, "mealdb")
            .build()
    }

    @Singleton
    @Provides
    fun provideSchoolNameDao(schoolMealDatabase: SchoolMealDatabase): SchoolNameDao {
        return schoolMealDatabase.schoolNameDao()
    }

    @Singleton
    @Provides
    fun provideAllMealsDao(schoolMealDatabase: SchoolMealDatabase) : AllMealsDao{
        return schoolMealDatabase.allMealsDao()
    }
}