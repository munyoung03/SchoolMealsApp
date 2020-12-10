package com.example.schoolmealsapp.data.repository.school.datasourcelmpl

import com.example.schoolmealsapp.data.model.schoolname.SchoolNameData
import com.example.schoolmealsapp.data.repository.school.datasource.SchoolNameCacheDataSource

class SchoolNameCacheDataSourceImpl : SchoolNameCacheDataSource {

    private var schoolNameList = ArrayList<SchoolNameData>()
    override suspend fun getSchoolNameFromCache(): List<SchoolNameData> {
        return schoolNameList
    }

    override suspend fun saveSchoolNameToCache(schoolName: List<SchoolNameData>) {
        schoolNameList.clear()
        schoolNameList = ArrayList(schoolName)
    }


}