package com.example.schoolmealsapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.schoolmealsapp.domain.usecase.GetSchoolNameUseCase

class MainViewModelFactory(private val getSchoolNameUseCase: GetSchoolNameUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(getSchoolNameUseCase) as T
    }
}