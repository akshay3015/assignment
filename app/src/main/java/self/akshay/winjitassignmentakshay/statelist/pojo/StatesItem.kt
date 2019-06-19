package self.akshay.winjitassignmentakshay.statelist.pojo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class StatesItem(
	val applicants: List<ApplicantsItem?>? = null,
	val nameOfState: String? = null
):Parcelable
