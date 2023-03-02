package com.carfax.assignment.data.repository

import com.carfax.assignment.data.datasource.CarDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(private val carDataSource: CarDataSource) {

    suspend fun getCarsList() = carDataSource.getHomeResponse().listings
}