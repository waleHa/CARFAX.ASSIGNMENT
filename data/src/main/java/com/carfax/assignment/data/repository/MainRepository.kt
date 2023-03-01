package com.carfax.assignment.data.repository

import com.carfax.assignment.data.network.RetrofitBuilder

class MainRepository {
    suspend fun getList() = RetrofitBuilder.carListingsApi.getCars()
}