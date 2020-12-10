package com.example.schoolmealsapp.data.repository.school.datasource

import com.example.schoolmealsapp.data.model.schoolname.SchoolNameData

interface SchoolNameCacheDataSource {
    suspend fun getSchoolNameFromCache() : List<SchoolNameData>
    suspend fun saveSchoolNameToCache(schoolName : List<SchoolNameData>)
}