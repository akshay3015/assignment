package self.akshay.winjitassignmentakshay.statelist

import io.reactivex.Observable
import self.akshay.winjitassignmentakshay.network.API
import self.akshay.winjitassignmentakshay.statelist.pojo.ResponseStateList

class StatesRepository(val api : API) {

    fun getStates() : Observable<ResponseStateList> {

        return api.fetchFilms()
    }
}