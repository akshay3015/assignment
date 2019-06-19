package self.akshay.winjitassignmentakshay.network

import io.reactivex.Observable
import retrofit2.http.GET
import self.akshay.winjitassignmentakshay.statelist.pojo.ResponseStateList

interface API {
    @GET("db")
    fun fetchFilms(): Observable<ResponseStateList>
}