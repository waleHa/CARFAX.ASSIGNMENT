package com.wa7a.carfaxassignment.data.model


import com.google.gson.annotations.SerializedName

data class FirstPhoto(
    @SerializedName("large ")
    val large: String? = null,//REQUIRED
//    @SerializedName("medium")
//    val medium: String? = null,
//    @SerializedName("small")
//    val small: String? = null
)