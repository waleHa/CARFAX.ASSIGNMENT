package com.carfax.assignment.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DealerRemoteModel(
    @SerializedName("carfaxId")
    val carfaxId: String? = null,
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("state")
    val state: String
):Parcelable
