package com.aduc.kotlinpractis.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aduc.kotlinpractis.databinding.CustomItemLayoutBinding
import com.aduc.kotlinpractis.networking.detail.DetailDataModel


class DetailAdapter() :
    RecyclerView.Adapter<DetailAdapter.MyViewHolder>() {
    private val itemList = arrayListOf<DetailDataModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(CustomItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


    fun setItems(list: List<DetailDataModel>) {
        itemList.addAll(list)
        notifyDataSetChanged()
    }

    fun getItem(position: Int):DetailDataModel{
        return itemList[position]
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))

    }

    inner class MyViewHolder(val itemBinding: CustomItemLayoutBinding) : RecyclerView.ViewHolder(itemBinding.root) {


        fun bind(items: DetailDataModel)
        {
            itemBinding.title.text = items.title
        }

    }
}