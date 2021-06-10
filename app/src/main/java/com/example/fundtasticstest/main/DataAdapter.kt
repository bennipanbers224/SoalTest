package com.example.fundtasticstest.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fundtasticstest.MainActivity
import com.example.fundtasticstest.Models.Data
import com.example.fundtasticstest.R
import kotlinx.android.synthetic.main.data_item.view.*

class DataAdapter (var context:MainActivity, var dataList : ArrayList<Data>, private val itemClick:AdapterInterface):RecyclerView.Adapter<DataAdapter.ViewHolder>(){


    companion object{
        var mItemClick : AdapterInterface?=null
    }

    class ViewHolder (itemView : View): RecyclerView.ViewHolder(itemView) {
        val dataName = itemView.dataName
        val typeName = itemView.typeName
        val price = itemView.price_buy
        val mfid = itemView.mfId
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.data_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        mItemClick = itemClick
        holder.dataName.text = dataList[position].name_portofolio
        holder.typeName.text = dataList[position].mfTypeName
        holder.price.text = dataList[position].price_buy
        holder.mfid.text = dataList[position].mfid
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}