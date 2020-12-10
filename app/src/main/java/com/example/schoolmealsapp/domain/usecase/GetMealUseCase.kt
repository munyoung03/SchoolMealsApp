package com.example.schoolmealsapp.domain.usecase

import com.example.schoolmealsapp.data.model.meals.MealsData
import com.example.schoolmealsapp.domain.repository.AllMealsRepository
import com.example.schoolmealsapp.domain.repository.MealRepository

class GetMealUseCase(private val mealRepository: MealRepository) {

    suspend fun execute() : MealsData = mealRepository.getMeal()
}