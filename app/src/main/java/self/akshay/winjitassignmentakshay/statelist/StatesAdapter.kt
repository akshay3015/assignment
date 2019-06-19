package self.akshay.winjitassignmentakshay.statelist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.state_list_item.view.*
import self.akshay.winjitassignmentakshay.R
import self.akshay.winjitassignmentakshay.statelist.pojo.StatesItem

class StatesAdapter(private val states: List<StatesItem>, val clickListner : ItemClickListener ) : RecyclerView.Adapter<StatesAdapter.ViewHolder>() {

    interface ItemClickListener{

        fun onItemClick(stateItem: StatesItem)
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.state_list_item, p0, false))    }

    override fun getItemCount(): Int {
        return states.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0.stateName.text = states[p1].nameOfState
        p0.stateName.setOnClickListener{
            clickListner.onItemClick(states[p1])
        }
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val stateName: TextView = view.tv_state
    }
}