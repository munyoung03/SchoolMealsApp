package com.example.schoolmealsapp.domain.repository

import com.example.schoolmealsapp.data.model.schoolname.SchoolNameData

interface SchoolNameRepository {
    suspend fun getSchoolName() : List<SchoolNameData>
}