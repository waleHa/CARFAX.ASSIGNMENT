package com.wa7a.carfaxassignment.data.model


import com.google.gson.annotations.SerializedName

data class Images(
//    @SerializedName("baseUrl")
//    val baseUrl: String? = null,
    @SerializedName("firstPhoto")
    val firstPhoto: FirstPhoto? = null,//REQUIRED
//    @SerializedName("large")
//    val large: List<String?>? = null,
//    @SerializedName("medium")
//    val medium: List<String?>? = null,
//    @SerializedName("small")
//    val small: List<String?>? = null
)