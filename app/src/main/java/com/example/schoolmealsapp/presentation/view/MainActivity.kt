package com.example.schoolmealsapp.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.schoolmealsapp.R
import com.example.schoolmealsapp.data.api.MealsService
import com.example.schoolmealsapp.data.api.RetrofitInstance
import com.example.schoolmealsapp.data.db.SchoolMealDatabase
import com.example.schoolmealsapp.data.repository.school.SchoolNameRepositoryImpl
import com.example.schoolmealsapp.data.repository.school.datasourcelmpl.SchoolNameCacheDataSourceImpl
import com.example.schoolmealsapp.data.repository.school.datasourcelmpl.SchoolNameLocalDataSourceImpl
import com.example.schoolmealsapp.data.repository.school.datasourcelmpl.SchoolNameRemoteDataSourceImpl
import com.example.schoolmealsapp.databinding.ActivityMainBinding
import com.example.schoolmealsapp.domain.usecase.GetSchoolNameUseCase
import com.example.schoolmealsapp.presentation.di.Injector
import com.example.schoolmealsapp.presentation.viewmodel.MainViewModel
import com.example.schoolmealsapp.presentation.viewmodel.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory : MainViewModelFactory

    lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        (application as Injector).createSchoolNameSubComponent()
            .inject(this)

        mainViewModel = ViewModelProvider(this, factory)
            .get(MainViewModel::class.java)

        val responseLiveData = mainViewModel.getSchoolName()
        responseLiveData.observe(this, Observer {
            Log.d("TAG", "$it")
        })

    }
}