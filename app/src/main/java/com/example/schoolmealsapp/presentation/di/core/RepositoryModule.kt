package com.example.schoolmealsapp.presentation.di.core

import com.example.schoolmealsapp.data.db.SchoolMealDatabase
import com.example.schoolmealsapp.data.repository.allmeals.AllMealsRepositoryImpl
import com.example.schoolmealsapp.data.repository.allmeals.datasource.AllMealsCacheDataSource
import com.example.schoolmealsapp.data.repository.allmeals.datasource.AllMealsLocalDataSource
import com.example.schoolmealsapp.data.repository.allmeals.datasource.AllMealsRemoteDataSource
import com.example.schoolmealsapp.data.repository.school.SchoolNameRepositoryImpl
import com.example.schoolmealsapp.data.repository.school.datasource.SchoolNameCacheDataSource
import com.example.schoolmealsapp.data.repository.school.datasource.SchoolNameLocalDataSource
import com.example.schoolmealsapp.data.repository.school.datasource.SchoolNameRemoteDataSource
import com.example.schoolmealsapp.domain.repository.AllMealsRepository
import com.example.schoolmealsapp.domain.repository.SchoolNameRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideSchoolNameRepository(
        schoolNameRemoteDataSource: SchoolNameRemoteDataSource,
        schoolNameLocalDataSource: SchoolNameLocalDataSource,
        schoolNameCacheDataSource: SchoolNameCacheDataSource
    ) : SchoolNameRepository
    {
        return SchoolNameRepositoryImpl(
            schoolNameLocalDataSource,
            schoolNameRemoteDataSource,
            schoolNameCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideAllMealsRepository(
        allMealsRemoteDataSource: AllMealsRemoteDataSource,
        allMealsLocalDataSource: AllMealsLocalDataSource,
        allMealsCacheDataSource: AllMealsCacheDataSource,
        mealsDatabase: SchoolMealDatabase
    ) : AllMealsRepository {
        return AllMealsRepositoryImpl(
            allMealsLocalDataSource,
            allMealsRemoteDataSource,
            allMealsCacheDataSource,
            mealsDatabase
        )
    }
}