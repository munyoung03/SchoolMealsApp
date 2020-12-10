package com.example.schoolmealsapp.domain.usecase

import com.example.schoolmealsapp.data.model.schoolname.SchoolNameData
import com.example.schoolmealsapp.domain.repository.SchoolNameRepository

class GetSchoolNameUseCase(private val schoolNameRepository: SchoolNameRepository) {
    suspend fun execute() : List<SchoolNameData> = schoolNameRepository.getSchoolName()
}