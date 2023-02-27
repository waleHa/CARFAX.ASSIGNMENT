package com.wa7a.carfaxassignment.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Dealer(
//    @SerializedName("address")
//    val address: String? = null,
    @SerializedName("carfaxId")
    val carfaxId: String? = null,
    @SerializedName("city")
    val city: String? = null,//REQUIRED?
//    @SerializedName("dealerAverageRating")
//    val dealerAverageRating: Double? = null,
//    @SerializedName("dealerInventoryUrl")
//    val dealerInventoryUrl: String? = null,
//    @SerializedName("dealerReviewCount")
//    val dealerReviewCount: Int? = null,
//    @SerializedName("dealerReviewDate")
//    val dealerReviewDate: String? = null,
//    @SerializedName("dealerReviewRating")
//    val dealerReviewRating: Int? = null,
//    @SerializedName("dealerReviewReviewer")
//    val dealerReviewReviewer: String? = null,
//    @SerializedName("latitude")
//    val latitude: String? = null,
//    @SerializedName("longitude")
//    val longitude: String? = null,
//    @SerializedName("name")
//    val name: String? = null,
//    @SerializedName("onlineOnly")
//    val onlineOnly: Boolean? = null,
    @SerializedName("phone")
    val phone: String? = null,//REQUIRED
    @SerializedName("state")
    val state: String? = null,//REQUIRED?
//    @SerializedName("zip")
//    val zip: String? = null
):Parcelable