package com.example.schoolmealsapp.data.repository.school.datasource

import com.example.schoolmealsapp.data.model.schoolname.Data
import com.example.schoolmealsapp.data.model.schoolname.SchoolNameData
import retrofit2.Response

interface SchoolNameRemoteDataSource {
    suspend fun getSchoolName(name : String): Response<SchoolNameData>
}