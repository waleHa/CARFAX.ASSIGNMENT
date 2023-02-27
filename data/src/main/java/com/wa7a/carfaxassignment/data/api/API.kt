package com.wa7a.carfaxassignment.data.api

import com.wa7a.carfaxassignment.data.model.ConsumersResponse
import retrofit2.Response
import retrofit2.http.GET

interface API {
    @GET("/assignment.json")
    suspend fun getAchievementsResponse(): Response<ConsumersResponse>
}