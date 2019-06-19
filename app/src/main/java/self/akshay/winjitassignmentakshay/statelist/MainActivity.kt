package self.akshay.winjitassignmentakshay.statelist

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import self.akshay.winjitassignmentakshay.BuildConfig
import self.akshay.winjitassignmentakshay.HeatMap.HeatMapActivity
import self.akshay.winjitassignmentakshay.R
import self.akshay.winjitassignmentakshay.network.API
import self.akshay.winjitassignmentakshay.network.getRetrofitInstance
import self.akshay.winjitassignmentakshay.statelist.pojo.StatesItem
import self.akshay.winjitassignmentakshay.utils.Utils
import java.util.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(), GetStatesContract.View , StatesAdapter.ItemClickListener {


    private lateinit var dialog: ProgressDialog

    override lateinit var presenter: GetStatesContract.Presenter
    private val stateList = mutableListOf<StatesItem>()

    private var adapter: StatesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        StatesPresenter(this, StatesRepository(getRetrofitInstance(true).create(API::class.java)))

        init()


    }

    private fun init() {
        adapter = StatesAdapter(stateList,this)
        rv_states.layoutManager = LinearLayoutManager(this)
        rv_states.adapter = adapter
    }


    override fun onResume() {
        super.onResume()

        if (stateList.size>0){
            return
        }

        if(Utils.isNetworkAvailble(applicationContext)){
            presenter.subscribe()
        }else{
            Toast.makeText(this,"No Internet Connection!",Toast.LENGTH_LONG).show()
        }


    }


    override fun onStop() {
        super.onStop()
        presenter.unsubscribe()
    }


    override fun showLoader(show: Boolean) {
        if (show) {

            dialog = ProgressDialog(this).also { it.setMessage("Please wait ...") }.also { it.show() }


        } else {
            dialog.dismiss()
        }

    }


    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }


    override fun setAdapter(list: List<StatesItem>) {
        if (BuildConfig.DEBUG) {
            println("data $list")
        }

        stateList.run {
            clear()
            addAll(list)
        }

        adapter?.notifyDataSetChanged()


    }


    override fun onItemClick(stateItem: StatesItem) {

        var intent = Intent(this,HeatMapActivity::class.java)
        intent.putExtra("heatMapData",stateItem)
        startActivity(intent)
    }

}
