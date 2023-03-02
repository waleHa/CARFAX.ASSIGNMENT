package com.carfax.assignment.data.datasource

import com.carfax.assignment.data.model.WrappedListingsRemoteModel
import retrofit2.http.GET

interface CarDataSource {
    @GET("/assignment.json")
    suspend fun getHomeResponse(): WrappedListingsRemoteModel
}
