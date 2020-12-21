package com.example.schoolmealsapp.presentation.di.core

import com.example.schoolmealsapp.domain.repository.SchoolNameRepository
import com.example.schoolmealsapp.domain.usecase.GetSchoolNameUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetSchoolNameUseCase(schoolNameRepository : SchoolNameRepository) : GetSchoolNameUseCase{
        return GetSchoolNameUseCase(schoolNameRepository)
    }
}