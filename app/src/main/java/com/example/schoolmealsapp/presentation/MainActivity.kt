package com.example.schoolmealsapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.schoolmealsapp.R
import com.example.schoolmealsapp.data.api.MealsService
import com.example.schoolmealsapp.data.api.RetrofitInstance
import com.example.schoolmealsapp.data.db.SchoolMealDatabase
import com.example.schoolmealsapp.data.repository.school.SchoolNameRepositoryImpl
import com.example.schoolmealsapp.data.repository.school.datasource.SchoolNameLocalDataSource
import com.example.schoolmealsapp.data.repository.school.datasource.SchoolNameRemoteDataSource
import com.example.schoolmealsapp.data.repository.school.datasourcelmpl.SchoolNameCacheDataSourceImpl
import com.example.schoolmealsapp.data.repository.school.datasourcelmpl.SchoolNameLocalDataSourceImpl
import com.example.schoolmealsapp.data.repository.school.datasourcelmpl.SchoolNameRemoteDataSourceImpl
import com.example.schoolmealsapp.databinding.ActivityMainBinding
import com.example.schoolmealsapp.domain.usecase.GetSchoolNameUseCase

class MainActivity : AppCompatActivity() {

    lateinit var factory : MainViewModelFactory

    lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        val dbDao = SchoolMealDatabase.getInstance(applicationContext).schoolNameDao()
        val retService = RetrofitInstance
            .getRetrofitInstance()
            .create(MealsService::class.java)

        val schoolCache = SchoolNameCacheDataSourceImpl()
        val schoolRemote = SchoolNameRemoteDataSourceImpl(retService, "대구")
        val schoolLocal = SchoolNameLocalDataSourceImpl(dbDao)
        val schoolRepo = SchoolNameRepositoryImpl(schoolLocal, schoolRemote, schoolCache)

        factory = MainViewModelFactory(GetSchoolNameUseCase(schoolRepo))

        mainViewModel = ViewModelProvider(this, factory)
            .get(MainViewModel::class.java)


        val responseLiveData = mainViewModel.getSchoolName()
        responseLiveData.observe(this, {
            Log.d("TAG", it[0].address)
        })
    }
}