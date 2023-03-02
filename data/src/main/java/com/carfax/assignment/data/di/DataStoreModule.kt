package com.carfax.assignment.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.carfax.assignment.data.model.WrappedHomeRemoteModel
import com.carfax.assignment.data.serializer.DataStoreSerializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    private const val DATA_STORE_FILE_NAME = "carfax_file.pb"

    @Provides
    @Singleton
    fun provideSettingsDataStore(@ApplicationContext context: Context): DataStore<WrappedHomeRemoteModel> {
        return DataStoreFactory.create(
            serializer = DataStoreSerializer(),
            produceFile = { context.dataStoreFile(DATA_STORE_FILE_NAME) },
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
        )
    }


}