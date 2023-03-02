package com.carfax.assignment.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CarRemoteModel(

    @SerializedName("bodytype")
    val bodyType: String? = null,
    @SerializedName("currentPrice")
    val currentPrice: Double? = null,
    @SerializedName("dealer")
    val dealer: DealerRemoteModel,
    @SerializedName("drivetype")
    val driveType: String? = null,
    @SerializedName("engine")
    val engine: String? = null,
    @SerializedName("exteriorColor")
    val exteriorColor: String? = null,
    @SerializedName("fuel")
    val fuel: String? = null,
    @SerializedName("images")
    val images: ImagesRemoteModel,
    @SerializedName("interiorColor")
    val interiorColor: String? = null,
    @SerializedName("make")
    val make: String? = null,
    @SerializedName("mileage")
    val mileage: Int? = null,
    @SerializedName("model")
    val model: String? = null,
    @SerializedName("transmission")
    val transmission: String? = null,
    @SerializedName("trim")
    val trim: String? = null,
    @SerializedName("vin")
    val vin: String? = null,
    @SerializedName("year")
    val year: Int? = null
) : Parcelable {
    fun listingDealerAddress() = "${dealer?.city}, ${dealer?.state}"

    fun listingPriceMileage() = "$ ${
        currentPrice?.toInt()?.formatDecimalSeparator()
    }  |  ${mileage?.formatNumberShortcut()} mi"

    fun listingYearMakeModelTrip() = "$year $make $model $trim"
    fun getImageUrl() = "${images?.large?.get(0)}"
}

fun Int.formatDecimalSeparator(): String {
    return toString()
        .reversed()
        .chunked(3)
        .joinToString(",")
        .reversed()
}

fun Int.formatNumberShortcut(): String {
    if (this < 1000)
        return "" + this
    val exp = (Math.log(this.toDouble()) / Math.log(1000.0)).toInt()
    return String.format("%.1f %c", this / Math.pow(1000.0, exp.toDouble()), "kM"[exp - 1])
}
