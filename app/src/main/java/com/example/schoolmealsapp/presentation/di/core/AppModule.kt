package com.example.schoolmealsapp.presentation.di.core

import android.content.Context
import com.example.schoolmealsapp.presentation.di.schoolname.SchoolNameSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [SchoolNameSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }
}