package com.example.schoolmealsapp.presentation.di

import com.example.schoolmealsapp.presentation.di.schoolname.SchoolNameSubComponent

interface Injector {
    fun createSchoolNameSubComponent() : SchoolNameSubComponent
}