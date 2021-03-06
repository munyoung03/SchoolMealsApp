package com.example.schoolmealsapp.data.api

import com.example.schoolmealsapp.data.model.allmeals.AllMealsData
import com.example.schoolmealsapp.data.model.schoolname.Data
import com.example.schoolmealsapp.data.model.schoolname.SchoolNameData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsService {

    @GET("school")
    suspend fun getSchoolName(
        @Query("name") name : String
    ) : Response<SchoolNameData>


    @GET("lotMeals")
    suspend fun getAllMeals(
        @Query("AD_CODE") adCode : String,
        @Query("SC_CODE") scCode : String,
        @Query("START") startTime : String,
        @Query("END") endTime : String
    ) : Response<AllMealsData>
}