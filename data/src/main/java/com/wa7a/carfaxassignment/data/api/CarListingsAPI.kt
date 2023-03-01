package com.wa7a.carfaxassignment.data.api

import com.wa7a.carfaxassignment.data.model.WrappedListingsRemoteModel
import retrofit2.Response
import retrofit2.http.GET

interface CarListingsAPI {
    @GET("/assignment.json")
    suspend fun getCarListingsResponse(): Response<WrappedListingsRemoteModel>
}