package com.carfax.assignment.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImagesRemoteModel(
    @SerializedName("firstPhoto")
    val firstPhoto: FirstPhotoRemoteModel,//REQUIRED
    @SerializedName("large")
    val large: List<String>? = null,
) : Parcelable
