package com.example.gardendemo.network.response
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PlantInfoResponse(
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("limit")
    val limit: Int = 0,
    @SerializedName("offset")
    val offset: Int = 0,
    @SerializedName("results")
    val results: ArrayList<PlantInfo> = ArrayList(),
    @SerializedName("sort")
    val sort: String = ""
)

data class PlantInfo(
    @SerializedName("F_AlsoKnown")
    val fAlsoKnown: String? = "",
    @SerializedName("F_Brief")
    val fBrief: String? = "",
    @SerializedName("F_CID")
    val fCID: String? = "",
    @SerializedName("F_Code")
    val fCode: String? = "",
    @SerializedName("F_Family")
    val fFamily: String? = "",
    @SerializedName("F_Feature")
    val fFeature: String? = "",
    @SerializedName("F_Function＆Application")
    val fFunction: String? = "",
    @SerializedName("F_Genus")
    val fGenus: String? = "",
    @SerializedName("F_Geo")
    val fGeo: String? = "",
    @SerializedName("F_Keywords")
    val fKeywords: String? = "",
    @SerializedName("F_Location")
    val fLocation: String? = "",
    @SerializedName("F_Name_En")
    val fNameEn: String? = "",
    @SerializedName("F_Name_Latin")
    val fNameLatin: String? = "",
    @SerializedName("F_pdf01_ALT")
    val fPdf01ALT: String? = "",
    @SerializedName("F_pdf01_URL")
    val fPdf01URL: String? = "",
    @SerializedName("F_pdf02_ALT")
    val fPdf02ALT: String? = "",
    @SerializedName("F_pdf02_URL")
    val fPdf02URL: String? = "",
    @SerializedName("F_Pic01_ALT")
    val fPic01ALT: String? = "",
    @SerializedName("F_Pic01_URL")
    val fPic01URL: String? = "",
    @SerializedName("F_Pic02_ALT")
    val fPic02ALT: String? = "",
    @SerializedName("F_Pic02_URL")
    val fPic02URL: String? = "",
    @SerializedName("F_Pic03_ALT")
    val fPic03ALT: String? = "",
    @SerializedName("F_Pic03_URL")
    val fPic03URL: String? = "",
    @SerializedName("F_Pic04_ALT")
    val fPic04ALT: String? = "",
    @SerializedName("F_Pic04_URL")
    val fPic04URL: String? = "",
    @SerializedName("F_Summary")
    val fSummary: String? = "",
    @SerializedName("F_Update")
    val fUpdate: String? = "",
    @SerializedName("F_Vedio_URL")
    val fVedioURL: String? = "",
    @SerializedName("F_Voice01_ALT")
    val fVoice01ALT: String? = "",
    @SerializedName("F_Voice01_URL")
    val fVoice01URL: String? = "",
    @SerializedName("F_Voice02_ALT")
    val fVoice02ALT: String? = "",
    @SerializedName("F_Voice02_URL")
    val fVoice02URL: String? = "",
    @SerializedName("F_Voice03_ALT")
    val fVoice03ALT: String? = "",
    @SerializedName("F_Voice03_URL")
    val fVoice03URL: String? = "",
    @SerializedName("F_Name_Ch")
    val fNameCH: String? = "",
    @SerializedName("_id")
    val id: Int = 0,

    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fAlsoKnown)
        parcel.writeString(fBrief)
        parcel.writeString(fCID)
        parcel.writeString(fCode)
        parcel.writeString(fFamily)
        parcel.writeString(fFeature)
        parcel.writeString(fFunction)
        parcel.writeString(fGenus)
        parcel.writeString(fGeo)
        parcel.writeString(fKeywords)
        parcel.writeString(fLocation)
        parcel.writeString(fNameEn)
        parcel.writeString(fNameLatin)
        parcel.writeString(fPdf01ALT)
        parcel.writeString(fPdf01URL)
        parcel.writeString(fPdf02ALT)
        parcel.writeString(fPdf02URL)
        parcel.writeString(fPic01ALT)
        parcel.writeString(fPic01URL)
        parcel.writeString(fPic02ALT)
        parcel.writeString(fPic02URL)
        parcel.writeString(fPic03ALT)
        parcel.writeString(fPic03URL)
        parcel.writeString(fPic04ALT)
        parcel.writeString(fPic04URL)
        parcel.writeString(fSummary)
        parcel.writeString(fUpdate)
        parcel.writeString(fVedioURL)
        parcel.writeString(fVoice01ALT)
        parcel.writeString(fVoice01URL)
        parcel.writeString(fVoice02ALT)
        parcel.writeString(fVoice02URL)
        parcel.writeString(fVoice03ALT)
        parcel.writeString(fVoice03URL)
        parcel.writeString(fNameCH)
        parcel.writeInt(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PlantInfo> {
        override fun createFromParcel(parcel: Parcel): PlantInfo {
            return PlantInfo(parcel)
        }

        override fun newArray(size: Int): Array<PlantInfo?> {
            return arrayOfNulls(size)
        }
    }
}