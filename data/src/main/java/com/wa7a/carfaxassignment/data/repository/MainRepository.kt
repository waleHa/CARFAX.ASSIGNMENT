package com.wa7a.carfaxassignment.data.repository

import com.wa7a.carfaxassignment.data.network.RetrofitBuilder

class MainRepository {
    suspend fun getList() = RetrofitBuilder.achievementApi.getAchievementsResponse()
}