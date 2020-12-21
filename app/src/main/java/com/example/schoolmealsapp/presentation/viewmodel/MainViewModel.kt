package com.example.schoolmealsapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.schoolmealsapp.data.db.SchoolMealDatabase
import com.example.schoolmealsapp.data.repository.allmeals.datasource.AllMealsCacheDataSource
import com.example.schoolmealsapp.data.repository.allmeals.datasource.AllMealsLocalDataSource
import com.example.schoolmealsapp.data.repository.allmeals.datasource.AllMealsRemoteDataSource
import com.example.schoolmealsapp.data.repository.school.SchoolNameRepositoryImpl
import com.example.schoolmealsapp.data.repository.school.datasource.SchoolNameCacheDataSource
import com.example.schoolmealsapp.data.repository.school.datasource.SchoolNameLocalDataSource
import com.example.schoolmealsapp.data.repository.school.datasource.SchoolNameRemoteDataSource
import com.example.schoolmealsapp.data.repository.school.datasourcelmpl.SchoolNameCacheDataSourceImpl
import com.example.schoolmealsapp.data.repository.school.datasourcelmpl.SchoolNameLocalDataSourceImpl
import com.example.schoolmealsapp.data.repository.school.datasourcelmpl.SchoolNameRemoteDataSourceImpl
import com.example.schoolmealsapp.domain.repository.SchoolNameRepository
import com.example.schoolmealsapp.domain.usecase.GetSchoolNameUseCase

class MainViewModel(private val getSchoolNameUseCase: GetSchoolNameUseCase) : ViewModel(){

    fun getSchoolName() = liveData{
        val schoolNameList = getSchoolNameUseCase.execute("대구소프트웨어고등학교")
        emit(schoolNameList)
    }
}