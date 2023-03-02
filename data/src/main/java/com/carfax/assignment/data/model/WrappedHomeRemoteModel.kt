package com.carfax.assignment.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class WrappedHomeRemoteModel(
    @SerializedName("listings")
    val listings: List<CarRemoteModel>
)
