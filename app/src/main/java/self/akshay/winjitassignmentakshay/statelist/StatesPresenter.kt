package self.akshay.winjitassignmentakshay.statelist

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import self.akshay.winjitassignmentakshay.statelist.pojo.ResponseStateList
import self.akshay.winjitassignmentakshay.statelist.pojo.StatesItem

class StatesPresenter (private val view: GetStatesContract.View,statesApi : StatesRepository) : GetStatesContract.Presenter {



    private lateinit var disposable: Disposable
    private  var statesRepo : StatesRepository


    init {
        view.presenter = this
        statesRepo = statesApi
    }




    override fun fetchStates() {
        view.showLoader(true)
        disposable = statesRepo.getStates()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    println(it)
                    view.setAdapter(it?.states as List<StatesItem>)
                    view.showLoader(false)
                }, {
                    it.printStackTrace()
                    view.showLoader(false)
                    view.showError(it.message.toString())

                }

            )    }

    override fun subscribe() {
        fetchStates()
    }

    override fun unsubscribe() {
        disposable.dispose()
    }


}