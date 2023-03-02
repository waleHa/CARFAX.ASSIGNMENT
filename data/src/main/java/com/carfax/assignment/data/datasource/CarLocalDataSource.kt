package com.carfax.assignment.data.datasource

import androidx.datastore.core.DataStore
import com.carfax.assignment.data.model.CarRemoteModel
import com.carfax.assignment.data.model.WrappedHomeRemoteModel
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class CarLocalDataSource @Inject constructor(
    private val dataStore: DataStore<WrappedHomeRemoteModel>
) {

    suspend fun  getList(): List<CarRemoteModel> {
        return  dataStore.data.first().listings
    }
    suspend fun saveList(list: List<CarRemoteModel>) {
        dataStore.updateData { cars ->
            cars.copy(
                listings = list
            )
        }
    }
}