package com.wa7a.carfaxassignment.data.network

import com.wa7a.carfaxassignment.data.BuildConfig
import com.wa7a.carfaxassignment.data.api.CarListingsAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val BASE_URL = BuildConfig.baseURL

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val carListingsApi: CarListingsAPI = retrofit.create(CarListingsAPI::class.java)
}