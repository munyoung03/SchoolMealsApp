package com.example.schoolmealsapp.presentation.di.core

import com.example.schoolmealsapp.data.repository.allmeals.datasource.AllMealsCacheDataSource
import com.example.schoolmealsapp.data.repository.allmeals.datasourcelmpl.AllMealsCacheDataSourceImpl
import com.example.schoolmealsapp.data.repository.school.datasource.SchoolNameCacheDataSource
import com.example.schoolmealsapp.data.repository.school.datasourcelmpl.SchoolNameCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideSchoolNameCacheDataSource() : SchoolNameCacheDataSource {
        return SchoolNameCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideAllMealsCacheDataSource() :AllMealsCacheDataSource{
        return AllMealsCacheDataSourceImpl()
    }
}