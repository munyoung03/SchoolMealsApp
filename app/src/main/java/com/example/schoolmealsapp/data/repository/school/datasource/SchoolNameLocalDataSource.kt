package com.example.schoolmealsapp.data.repository.school.datasource

import com.example.schoolmealsapp.data.model.schoolname.Sc

interface SchoolNameLocalDataSource {
    suspend fun getSchoolNameFromDB() : List<Sc>
    suspend fun saveSchoolNameToDB(schoolNames:List<Sc>)
    suspend fun clearAll()
}