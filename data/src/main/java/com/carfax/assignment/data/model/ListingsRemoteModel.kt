package com.carfax.assignment.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListingsRemoteModel(
//    @SerializedName("advantage")
//    val advantage: Boolean? = null,
//    @SerializedName("backfill")
//    val backfill: Boolean? = null,
//    @SerializedName("badge")
//    val badge: String? = null,
//    @SerializedName("bedLength")
//    val bedLength: String? = null,
    @SerializedName("bodytype")
    val bodyType: String? = null,//REQUIRED
//    @SerializedName("cabType")
//    val cabType: String? = null,
//    @SerializedName("certified")
//    val certified: Boolean? = null,
    @SerializedName("currentPrice")
    val currentPrice: Double? = null, //REQUIRED
    @SerializedName("dealer")
    val dealer: DealerRemoteModel? = null,//REQUIRED
//    @SerializedName("dealerType")
//    val dealerType: String? = null,
//    @SerializedName("displacement")
//    val displacement: String? = null,
//    @SerializedName("distanceToDealer")
//    val distanceToDealer: Double? = null,
    @SerializedName("drivetype")
    val driveType: String? = null,//REQUIRED
    @SerializedName("engine")
    val engine: String? = null,//REQUIRED
    @SerializedName("exteriorColor")
    val exteriorColor: String? = null, //REQUIRED
//    @SerializedName("firstSeen")
//    val firstSeen: String? = null,
//    @SerializedName("followCount")
//    val followCount: Int? = null,
//    @SerializedName("following")
//    val following: Boolean? = null,
    @SerializedName("fuel")
    val fuel: String? = null,
//    @SerializedName("hasViewed")
//    val hasViewed: Boolean? = null,
//    @SerializedName("id")
//    val id: String? = null,
//    @SerializedName("imageCount")
//    val imageCount: Int? = null,
    @SerializedName("images")
    val images: ImagesRemoteModel,//REQUIRED
    @SerializedName("interiorColor")
    val interiorColor: String? = null,//REQUIRED
//    @SerializedName("isEnriched")
//    val isEnriched: Boolean? = null,
//    @SerializedName("listPrice")
//    val listPrice: Double? = null,
    @SerializedName("make")
    val make: String? = null,
    @SerializedName("mileage")
    val mileage: Int? = null, //REQUIRED
    @SerializedName("model")
    val model: String? = null,
//    @SerializedName("monthlyPaymentEstimate")
//    val monthlyPaymentEstimate: MonthlyPaymentEstimate? = null,//DELETED
//    @SerializedName("mpgCity")
//    val mpgCity: Int? = null,
//    @SerializedName("mpgHighway")
//    val mpgHighway: Int? = null,
//    @SerializedName("noAccidents")
//    val noAccidents: Boolean? = null,
//    @SerializedName("oneOwner")
//    val oneOwner: Boolean? = null,
//    @SerializedName("onePrice")
//    val onePrice: Double? = null,
//    @SerializedName("onlineOnly")
//    val onlineOnly: Boolean? = null,
//    @SerializedName("personalUse")
//    val personalUse: Boolean? = null,
//    @SerializedName("recordType")
//    val recordType: String? = null,
//    @SerializedName("sentLead")
//    val sentLead: Boolean? = null,
//    @SerializedName("sentLeadAt")
//    val sentLeadAt: Any? = null,
//    @SerializedName("serviceRecords")
//    val serviceRecords: Boolean? = null,
//    @SerializedName("sortScore")
//    val sortScore: Double? = null,
//    @SerializedName("stockNumber")
//    val stockNumber: String? = null,
//    @SerializedName("subTrim")
//    val subTrim: String? = null,
//    @SerializedName("topOptions")
//    val topOptions: List<String?>? = null,
    @SerializedName("transmission")
    val transmission: String? = null,//REQUIRED
    @SerializedName("trim")
    val trim: String? = null,
//    @SerializedName("vdpUrl")
//    val vdpUrl: String? = null,
//    @SerializedName("vehicleCondition")
//    val vehicleCondition: String? = null,
    @SerializedName("vin")
    val vin: String? = null,//REQUIRED
    @SerializedName("year")
    val year: Int? = null
):Parcelable
{
    fun listingDealerAddress() = "${dealer?.city}, ${dealer?.state}"

    fun listingPriceMileage() = "$ ${currentPrice?.toInt()?.formatDecimalSeparator()}  |  ${mileage?.formatNumberShortcut()} mi"

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