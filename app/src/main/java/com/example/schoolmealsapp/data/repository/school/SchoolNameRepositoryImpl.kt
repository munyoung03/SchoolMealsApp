package com.example.schoolmealsapp.data.repository.school

import android.util.Log
import com.example.schoolmealsapp.data.model.schoolname.Sc
import com.example.schoolmealsapp.data.repository.school.datasource.SchoolNameCacheDataSource
import com.example.schoolmealsapp.data.repository.school.datasource.SchoolNameLocalDataSource
import com.example.schoolmealsapp.data.repository.school.datasource.SchoolNameRemoteDataSource
import com.example.schoolmealsapp.domain.repository.SchoolNameRepository
import java.lang.Exception

class SchoolNameRepositoryImpl(
    private val schoolNameLocalDataSource: SchoolNameLocalDataSource,
    private val schoolNameRemoteDataSource: SchoolNameRemoteDataSource,
    private val schoolNameCacheDataSource: SchoolNameCacheDataSource
) : SchoolNameRepository {
    
    override suspend fun getSchoolName(name : String): List<Sc> {
        return getSchoolNameFromCache(name)
    }

    suspend fun getSchoolNameFromAPI(name : String) : List<Sc> {
        lateinit var schoolNameList : List<Sc>
        try{
            val response = schoolNameRemoteDataSource.getSchoolName(name)
            val body = response.body()
            if(body != null){
                schoolNameList = body.data.sc_list
            }
        }catch (exception : Exception){
            Log.d("TAG", exception.message.toString())
        }
        return schoolNameList
    }

    suspend fun getSchoolNameFromDB(name : String) : List<Sc> {
        lateinit var schoolNameList : List<Sc>
        try{
            schoolNameList = schoolNameLocalDataSource.getSchoolNameFromDB()

        }catch (exception : Exception){
            Log.d("TAG", exception.message.toString())
        }
        if(schoolNameList.size > 0){
            return schoolNameList
        }else{
            schoolNameList = getSchoolNameFromAPI(name)
            schoolNameLocalDataSource.saveSchoolNameToDB(schoolNameList)
        }
        return schoolNameList
    }

    suspend fun getSchoolNameFromCache(name : String) : List<Sc> {
        lateinit var schoolNameList : List<Sc>
        try{
            schoolNameList = schoolNameCacheDataSource.getSchoolNameFromCache()

        }catch (exception : Exception){
            Log.d("TAG", exception.message.toString())
        }
        if(schoolNameList.size > 0){
            return schoolNameList
        }else{
            schoolNameList = getSchoolNameFromDB(name)
            schoolNameCacheDataSource.saveSchoolNameToCache(schoolNameList)
        }
        return schoolNameList
    }


}