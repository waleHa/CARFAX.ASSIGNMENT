package com.carfax.assignment.data.repository

import android.util.Log
import com.carfax.assignment.data.datasource.CarLocalDataSource
import com.carfax.assignment.data.datasource.CarRemoteDataSource
import com.carfax.assignment.data.model.CarRemoteModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(
    private val carRemoteDataSource: CarRemoteDataSource,
    private val localDataSource: CarLocalDataSource,
) {

    suspend fun getCarsList(): List<CarRemoteModel> {
        var list: List<CarRemoteModel>
        try {
            list = carRemoteDataSource.getHomeResponse().listings
            localDataSource.saveList(list)
        } catch (e: Exception) {
            list = localDataSource.getList()
        }
        Log.e("Log00",carRemoteDataSource.getHomeResponse().listings[0].driveType.toString())
        return list
    }


}