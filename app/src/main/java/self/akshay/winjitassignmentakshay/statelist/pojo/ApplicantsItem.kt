package self.akshay.winjitassignmentakshay.statelist.pojo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ApplicantsItem(
    val lng: Double,
    val nameOfApplicant: String? = null,
    val lat: Double
) : Parcelable
