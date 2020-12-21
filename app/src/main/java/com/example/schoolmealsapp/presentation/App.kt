package com.example.schoolmealsapp.presentation

import android.app.Application
import com.example.schoolmealsapp.presentation.di.Injector
import com.example.schoolmealsapp.presentation.di.core.*
import com.example.schoolmealsapp.presentation.di.schoolname.SchoolNameSubComponent

class App : Application(), Injector{

    private lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule("https://kyj-school-server.herokuapp.com/"))
            .remoteDataModule(RemoteDataModule())
            .build()
    }

    override fun createSchoolNameSubComponent(): SchoolNameSubComponent {
        return appComponent.schoolNameSubComponent().create()
    }

}