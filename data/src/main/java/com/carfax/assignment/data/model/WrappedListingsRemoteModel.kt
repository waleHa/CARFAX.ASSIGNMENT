package com.carfax.assignment.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WrappedListingsRemoteModel(
//    @SerializedName("backfillCount")
//    val backfillCount: Int? = null,
//    @SerializedName("dealerNewCount")
//    val dealerNewCount: Int? = null,
//    @SerializedName("dealerUsedCount")
//    val dealerUsedCount: Int? = null,
//    @SerializedName("enhancedCount")
//    val enhancedCount: Int? = null,
    @SerializedName("listings")
    val listings: List<ListingsRemoteModel?>? = null, //REQUIRED
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
):Parcelable