package com.example.birca.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.birca.R
import com.example.birca.model.cafeListResponseModel
import org.w3c.dom.Text

class CafeListAdapter (
    private var cafeList : MutableList<cafeListResponseModel> = mutableListOf()
) : RecyclerView.Adapter<CafeListAdapter.ViewHolder>() {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){

        var rv_item_cafelist_cafename : TextView
        var rv_item_cafelist_address : TextView
        var rv_item_cafelist_image : ImageView

        init {
            rv_item_cafelist_cafename = view.findViewById(R.id.rv_item_cafelist_cafename)
            rv_item_cafelist_address = view.findViewById(R.id.rv_item_cafelist_address)
            rv_item_cafelist_image = view.findViewById(R.id.rv_item_cafelist_image)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CafeListAdapter.ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.cafelist_rv_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CafeListAdapter.ViewHolder, position: Int) {

        holder.rv_item_cafelist_cafename.text = cafeList[position].cafeName
        holder.rv_item_cafelist_address.text = cafeList[position].address
        holder.rv_item_cafelist_image.setImageResource(cafeList[position].imageUrl)
    }

    override fun getItemCount(): Int {
        return cafeList.size
    }

}