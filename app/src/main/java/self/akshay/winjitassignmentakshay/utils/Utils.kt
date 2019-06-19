package self.akshay.winjitassignmentakshay.utils

import android.content.Context
import android.net.ConnectivityManager



@Suppress("DEPRECATION")
class Utils {
    companion object {
        fun isNetworkAvailble(ctx: Context): Boolean {
            val cm = ctx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val activeNetwork = cm.activeNetworkInfo

            return activeNetwork != null && activeNetwork.isConnectedOrConnecting
        }
    }
}