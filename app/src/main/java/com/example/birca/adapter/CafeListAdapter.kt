package com.example.birca.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.birca.R
import com.example.birca.model.CafeListResponseModel
import com.example.birca.model.IdolResponseModel

class CafeListAdapter(private var cafeList: ArrayList<CafeListResponseModel>) :
    RecyclerView.Adapter<CafeListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CafeListAdapter.ViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item_cafe_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CafeListAdapter.ViewHolder, position: Int) {

        val item = cafeList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {

        return cafeList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var cafeImageUrl: ImageView = view.findViewById(R.id.imageview_cafe)
        var cafeItemName: TextView = view.findViewById(R.id.text_cafe_item_name)
        var cafeLocationTag: TextView = view.findViewById(R.id.text_location_tag)

        fun bind(item: CafeListResponseModel) {

            Glide.with(itemView.context)
                .load(item.cafeImageUrl)
                .into(cafeImageUrl)

            cafeItemName.text = item.cafeItemName
            cafeLocationTag.text = item.cafeLocationTag


        }
    }

}