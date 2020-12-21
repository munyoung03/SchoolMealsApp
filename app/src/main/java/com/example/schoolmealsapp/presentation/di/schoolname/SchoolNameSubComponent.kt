package com.example.schoolmealsapp.presentation.di.schoolname

import com.example.schoolmealsapp.presentation.view.MainActivity
import dagger.Subcomponent

@SchoolNameScope
@Subcomponent(modules = [SchoolNameModule::class])
interface SchoolNameSubComponent {
    fun inject(mainActivity : MainActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():SchoolNameSubComponent
    }
}