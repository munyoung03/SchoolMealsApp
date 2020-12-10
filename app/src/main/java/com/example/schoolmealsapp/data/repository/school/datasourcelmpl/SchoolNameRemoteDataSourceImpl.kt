package com.example.schoolmealsapp.data.repository.school.datasourcelmpl

import com.example.schoolmealsapp.data.api.MealsService
import com.example.schoolmealsapp.data.model.schoolname.Data
import com.example.schoolmealsapp.data.model.schoolname.Sc
import com.example.schoolmealsapp.data.model.schoolname.SchoolNameData
import com.example.schoolmealsapp.data.repository.school.datasource.SchoolNameRemoteDataSource
import retrofit2.Response

class SchoolNameRemoteDataSourceImpl(private val mealsService: MealsService, private val name: String) :
    SchoolNameRemoteDataSource {
    override suspend fun getSchoolName(): Response<SchoolNameData> = mealsService.getSchoolName(name)

}