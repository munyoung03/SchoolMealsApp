package com.example.schoolmealsapp.data.repository.school.datasourcelmpl

import com.example.schoolmealsapp.data.db.SchoolNameDao
import com.example.schoolmealsapp.data.model.schoolname.SchoolNameData
import com.example.schoolmealsapp.data.repository.school.datasource.SchoolNameLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SchoolNameLocalDataSourceImpl(private val schoolNameDao: SchoolNameDao) :
    SchoolNameLocalDataSource {
    override suspend fun getSchoolNameFromDB(): List<SchoolNameData> = schoolNameDao.getSchoolName()

    override suspend fun saveSchoolNameToDB(schoolName: List<SchoolNameData>) {
        CoroutineScope(Dispatchers.IO).launch {
            schoolNameDao.saveSchoolName(schoolName)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            schoolNameDao.deleteAllSchoolName()
        }
    }
}