package com.example.schoolmealsapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schoolmealsapp.data.model.schoolname.Sc

@Dao
interface SchoolNameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSchoolName(schoolName : List<Sc>)

    @Query("DELETE FROM school_name")
    suspend fun deleteAllSchoolName()

    @Query("SELECT * FROM school_name")
    suspend fun getSchoolName() : List<Sc>
}