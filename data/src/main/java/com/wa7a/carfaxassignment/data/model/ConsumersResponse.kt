package com.wa7a.carfaxassignment.data.model


import com.google.gson.annotations.SerializedName

data class ConsumersResponse(
//    @SerializedName("backfillCount")
//    val backfillCount: Int? = null,
//    @SerializedName("dealerNewCount")
//    val dealerNewCount: Int? = null,
//    @SerializedName("dealerUsedCount")
//    val dealerUsedCount: Int? = null,
//    @SerializedName("enhancedCount")
//    val enhancedCount: Int? = null,
    @SerializedName("listings")//REQUIRED
    val listings: List<Listings?>? = null,
//    @SerializedName("page")
//    val page: Int? = null,
//    @SerializedName("pageSize")
//    val pageSize: Int? = null,
//    @SerializedName("searchArea")
//    val searchArea: SearchArea? = null,//Deleted
//    @SerializedName("totalListingCount")
//    val totalListingCount: Int? = null,
//    @SerializedName("totalPageCount")
//    val totalPageCount: Int? = null
)