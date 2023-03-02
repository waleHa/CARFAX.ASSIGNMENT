package com.carfax.assignment.data.model

import com.carfax.assignment.core.utils.formatDecimalSeparator
import com.carfax.assignment.core.utils.formatNumberShortcut
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable
import java.io.Serializable as SerializableIO

@Serializable
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
):SerializableIO {

    fun carAddress() = "${dealer?.city}, ${dealer?.state}"

    fun listingPriceMileage() = "$ ${
        currentPrice?.toInt()?.formatDecimalSeparator()
    }  |  ${mileage?.formatNumberShortcut()} mi"

    fun listingYearMakeModelTrip() = "$year $make $model $trim"

    fun getImageUrl() = "${images?.large?.get(0)}"
}

