package com.example.schoolmealsapp.domain.repository

import com.example.schoolmealsapp.data.model.schoolname.Sc

interface SchoolNameRepository {
    suspend fun getSchoolName(name : String) : List<Sc>
}