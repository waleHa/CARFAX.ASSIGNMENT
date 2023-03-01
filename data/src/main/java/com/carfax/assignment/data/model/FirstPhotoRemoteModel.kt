package com.carfax.assignment.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FirstPhotoRemoteModel(
    @SerializedName("large ")
    val large: String? = null,//REQUIRED
//    @SerializedName("medium")
//    val medium: String? = null,
//    @SerializedName("small")
//    val small: String? = null
):Parcelable