package com.ahmet.gramerapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ahmet.gramerapp.R
import com.ahmet.gramerapp.service.Kategori
import com.ahmet.gramerapp.view.HomeFragmentDirections

class Adaptery(private val list1: ArrayList<Kategori>): RecyclerView.Adapter<Adaptery.Holder>() {

    class Holder(itemView:View):RecyclerView.ViewHolder(itemView) {

        var rowText:TextView=itemView.findViewById(R.id.rowText)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.rowText.text=list1[position].name


        holder.itemView.setOnClickListener {

            val action=HomeFragmentDirections.actionHomeFragmentToObjectsFragment(list1[position].id.toInt())
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return list1.size
    }

    fun updateGramer(updateGramers:List<Kategori>) {
        list1.clear()
        list1.addAll(updateGramers)
        notifyDataSetChanged()
    }


}