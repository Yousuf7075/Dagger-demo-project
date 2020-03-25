package com.example.daggerdemo.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerdemo.R
import com.example.daggerdemo.model.DataRP
import kotlinx.android.synthetic.main.item_row.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private lateinit var listOfData : List<DataRP>

    fun setDataList(DataList : List<DataRP>){
        this.listOfData = DataList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listOfData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = listOfData[position].id.toString() + "."
        holder.name.text = listOfData[position].name
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val id  = itemView.idTV!!
        val name = itemView.nameTV!!
    }
}