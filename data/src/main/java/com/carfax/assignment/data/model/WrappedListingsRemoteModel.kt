package com.carfax.assignment.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WrappedListingsRemoteModel(
    @SerializedName("listings")
    val listings: List<CarRemoteModel>
) : Parcelable
