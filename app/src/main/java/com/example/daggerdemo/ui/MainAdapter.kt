package com.example.daggerdemo.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerdemo.R
import com.example.daggerdemo.model.ApiRP
import kotlinx.android.synthetic.main.item_row.view.*

class MainAdapter(private val allData: List<ApiRP>): RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return allData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.e("Data", "$allData")
        holder.id.text = allData[position].id.toString() + "."
        holder.name.text = allData[position].name
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val id  = itemView.idTV!!
        val name = itemView.nameTV!!
    }
}