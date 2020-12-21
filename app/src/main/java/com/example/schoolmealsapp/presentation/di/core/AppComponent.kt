package com.example.schoolmealsapp.presentation.di.core

import com.example.schoolmealsapp.presentation.di.schoolname.SchoolNameSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DataBaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
])
interface AppComponent {
    fun schoolNameSubComponent() : SchoolNameSubComponent.Factory
}