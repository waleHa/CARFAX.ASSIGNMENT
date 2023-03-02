package com.carfax.assignment.data.datasource

import com.carfax.assignment.data.model.WrappedHomeRemoteModel
import retrofit2.http.GET

interface CarRemoteDataSource {
    @GET("/assignment.json")
    suspend fun getHomeResponse(): WrappedHomeRemoteModel
}
