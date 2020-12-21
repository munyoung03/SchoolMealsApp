package com.example.schoolmealsapp.presentation.di.core

import com.example.schoolmealsapp.data.db.AllMealsDao
import com.example.schoolmealsapp.data.db.SchoolNameDao
import com.example.schoolmealsapp.data.repository.allmeals.datasource.AllMealsLocalDataSource
import com.example.schoolmealsapp.data.repository.allmeals.datasourcelmpl.AllMealsLocalDataSourceImpl
import com.example.schoolmealsapp.data.repository.school.datasource.SchoolNameLocalDataSource
import com.example.schoolmealsapp.data.repository.school.datasourcelmpl.SchoolNameLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Provides
    @Singleton
    fun provideSchoolNameLocalDataSource(schoolNameDao: SchoolNameDao) : SchoolNameLocalDataSource{
        return SchoolNameLocalDataSourceImpl(schoolNameDao)
    }

    @Provides
    @Singleton
    fun provideAllMealsLocalDataSource(allMealsDao: AllMealsDao) : AllMealsLocalDataSource{
        return AllMealsLocalDataSourceImpl(allMealsDao)
    }
}