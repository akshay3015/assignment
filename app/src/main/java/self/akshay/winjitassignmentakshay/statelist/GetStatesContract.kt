package self.akshay.winjitassignmentakshay.statelist

import self.akshay.winjitassignmentakshay.BasePresenter
import self.akshay.winjitassignmentakshay.BaseView
import self.akshay.winjitassignmentakshay.statelist.pojo.StatesItem

interface GetStatesContract {

    interface View : BaseView<Presenter> {

        fun showLoader(show: Boolean)

        fun showError(error: String)

        fun setAdapter(list: List<StatesItem>)


    }


    interface Presenter : BasePresenter {

        fun fetchStates()
    }
}