package com.carfax.assignment.data.network

import com.carfax.assignment.data.BuildConfig
import com.carfax.assignment.data.datasource.CarDataSource
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val BASE_URL = BuildConfig.baseURL

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val carListingsApi: CarDataSource = retrofit.create(CarDataSource::class.java)
}