package com.example.schoolmealsapp.presentation.di.schoolname

import com.example.schoolmealsapp.domain.usecase.GetSchoolNameUseCase
import com.example.schoolmealsapp.presentation.viewmodel.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class SchoolNameModule {
    @SchoolNameScope
    @Provides
    fun provideSchoolNameViewModelFactory(
        getSchoolNameUseCase: GetSchoolNameUseCase
    ) : MainViewModelFactory {
        return MainViewModelFactory(getSchoolNameUseCase)
    }
}