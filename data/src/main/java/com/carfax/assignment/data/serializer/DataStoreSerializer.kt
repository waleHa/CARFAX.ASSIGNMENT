package com.carfax.assignment.data.serializer

import androidx.datastore.core.Serializer
import com.carfax.assignment.data.model.WrappedHomeRemoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

class DataStoreSerializer(
    override val defaultValue: WrappedHomeRemoteModel
    = WrappedHomeRemoteModel(emptyList())
) : Serializer<WrappedHomeRemoteModel> {

    override suspend fun readFrom(input: InputStream): WrappedHomeRemoteModel {
        return try {
            Json.decodeFromString(
                deserializer = WrappedHomeRemoteModel.serializer(),
                string = input.readBytes().decodeToString(),
            )
        } catch (e: SerializationException) {
            e.printStackTrace()
            defaultValue
        }
    }

    override suspend fun writeTo(t: WrappedHomeRemoteModel, output: OutputStream) {
        withContext(Dispatchers.IO) {
            output.write(
                Json.encodeToString(
                    serializer = WrappedHomeRemoteModel.serializer(),
                    value = t,
                ).toByteArray()
            )
        }
    }
}