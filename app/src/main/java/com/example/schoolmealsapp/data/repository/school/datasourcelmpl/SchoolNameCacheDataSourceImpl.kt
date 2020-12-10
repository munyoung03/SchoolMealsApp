package com.example.schoolmealsapp.data.repository.school.datasourcelmpl

import com.example.schoolmealsapp.data.model.schoolname.Sc
import com.example.schoolmealsapp.data.repository.school.datasource.SchoolNameCacheDataSource

class SchoolNameCacheDataSourceImpl : SchoolNameCacheDataSource {

    private var schoolNameList = ArrayList<Sc>()
    override suspend fun getSchoolNameFromCache(): List<Sc> {
        return schoolNameList
    }

    override suspend fun saveSchoolNameToCache(schoolName: List<Sc>) {
        schoolNameList.clear()
        schoolNameList = ArrayList(schoolName)
    }


}