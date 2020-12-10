package com.example.schoolmealsapp.domain.usecase

import com.example.schoolmealsapp.data.model.allmeals.AllMeals
import com.example.schoolmealsapp.data.model.allmeals.AllMealsData
import com.example.schoolmealsapp.domain.repository.AllMealsRepository

class GetAllMealsUseCase(private val allMealsRepository: AllMealsRepository) {
    suspend fun execute() : List<AllMeals> = allMealsRepository.getAllMeals()
}