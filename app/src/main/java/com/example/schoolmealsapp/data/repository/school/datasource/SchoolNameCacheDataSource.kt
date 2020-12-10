package com.example.schoolmealsapp.data.repository.school.datasource

import com.example.schoolmealsapp.data.model.schoolname.Sc

interface SchoolNameCacheDataSource {
    suspend fun getSchoolNameFromCache() : List<Sc>
    suspend fun saveSchoolNameToCache(schoolName : List<Sc>)
}