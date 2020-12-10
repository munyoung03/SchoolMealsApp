package com.example.schoolmealsapp.data.repository.school.datasource

import com.example.schoolmealsapp.data.model.schoolname.SchoolNameData

interface SchoolNameLocalDataSource {
    suspend fun getSchoolNameFromDB() : List<SchoolNameData>
    suspend fun saveSchoolNameToDB(schoolNames:List<SchoolNameData>)
    suspend fun clearAll()
}