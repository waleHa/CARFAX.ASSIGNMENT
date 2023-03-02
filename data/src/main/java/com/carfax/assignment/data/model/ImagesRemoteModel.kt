package com.carfax.assignment.data.model


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class ImagesRemoteModel(
    @SerializedName("firstPhoto")
    val firstPhoto: FirstPhotoRemoteModel,
    @SerializedName("large")
    val large: List<String>? = null,
)
