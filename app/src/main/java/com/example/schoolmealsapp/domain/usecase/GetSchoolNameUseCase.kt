package com.example.schoolmealsapp.domain.usecase

import com.example.schoolmealsapp.data.model.schoolname.Sc
import com.example.schoolmealsapp.domain.repository.SchoolNameRepository

class GetSchoolNameUseCase(private val schoolNameRepository: SchoolNameRepository) {
    suspend fun execute(name : String) : List<Sc> = schoolNameRepository.getSchoolName(name)
}