package com.example.schoolmealsapp.retrofit

import com.example.schoolmealsapp.data.schoolname.SchoolNameData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsService {

    @GET("school")
    suspend fun getSchoolName(
        @Query("name") name : String
    ) : Response<SchoolNameData>

}