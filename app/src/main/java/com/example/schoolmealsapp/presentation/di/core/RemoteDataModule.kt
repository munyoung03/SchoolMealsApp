package com.example.schoolmealsapp.presentation.di.core

import com.example.schoolmealsapp.data.api.MealsService
import com.example.schoolmealsapp.data.repository.allmeals.datasource.AllMealsRemoteDataSource
import com.example.schoolmealsapp.data.repository.allmeals.datasourcelmpl.AllMealsRemoteDataSourceImpl
import com.example.schoolmealsapp.data.repository.school.datasource.SchoolNameRemoteDataSource
import com.example.schoolmealsapp.data.repository.school.datasourcelmpl.SchoolNameRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(
) {

    @Singleton
    @Provides
    fun provideSchoolNameRemoteDataSource(mealsService: MealsService): SchoolNameRemoteDataSource {
        return SchoolNameRemoteDataSourceImpl(mealsService)
    }

    @Singleton
    @Provides
    fun provideAllMealRemoteDataSource(mealsService: MealsService): AllMealsRemoteDataSource {
        return AllMealsRemoteDataSourceImpl(mealsService)
    }
}