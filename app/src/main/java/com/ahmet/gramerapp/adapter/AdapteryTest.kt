package com.ahmet.gramerapp.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahmet.gramerapp.R
import com.ahmet.gramerapp.service.Test
import kotlinx.android.synthetic.main.rowobject.view.*

class AdapteryTest(private val list2:ArrayList<Test>):RecyclerView.Adapter<AdapteryTest.Holder2> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapteryTest.Holder2 {
        val view2=LayoutInflater.from(parent.context).inflate(R.layout.rowobject,parent,false)
        return Holder2(view2)
    }

    override fun onBindViewHolder(holder: AdapteryTest.Holder2, position: Int) {
        holder.itemView.rowTest.text=list2[position].test_name
    }

    override fun getItemCount(): Int {
        return list2.size
    }

    fun updateTest(updateTests:List<Test>){
        list2.clear()
        list2.addAll(updateTests)
        notifyDataSetChanged()
    }

    class Holder2 (var view: View) : RecyclerView.ViewHolder(view) {

    }
}