package self.akshay.winjitassignmentakshay.statelist.pojo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseStateList(
	val states: List<StatesItem?>? = null
) : Parcelable
