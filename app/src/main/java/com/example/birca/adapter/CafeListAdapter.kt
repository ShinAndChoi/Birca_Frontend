package com.example.birca.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.birca.R
import com.example.birca.model.cafeListResponseModel

import okhttp3.internal.notifyAll
import org.w3c.dom.Text


class CafeListAdapter(
    private var cafeList: ArrayList<cafeListResponseModel>
) : RecyclerView.Adapter<CafeListAdapter.ViewHolder>() {


    fun updateList(newList: ArrayList<cafeListResponseModel>) {
        cafeList.clear()
        cafeList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CafeListAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cafelist_rv_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CafeListAdapter.ViewHolder, position: Int) {

//        holder.rv_item_cafelist_cafename.text = cafeList[position].cafeName
//        holder.rv_item_cafelist_address.text = cafeList[position].address
//        holder.rv_item_cafelist_image.setImageResource(cafeList[position].imageUrl)
//

        val item = cafeList[position]
        holder.bind(item)


    }

    override fun getItemCount(): Int {
        return cafeList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var rv_item_cafelist_cafename: TextView = view.findViewById(R.id.rv_item_cafelist_cafename)
        var rv_item_cafelist_address: TextView = view.findViewById(R.id.rv_item_cafelist_address)
        var rv_item_cafelist_image: ImageView = view.findViewById(R.id.rv_item_cafelist_image)


        fun bind(item: cafeListResponseModel) {
            rv_item_cafelist_cafename.text = item.cafeName
            rv_item_cafelist_address.text = item.address
            Glide.with(itemView.context)
                .load(item.imageUrl)
                .into(rv_item_cafelist_image)
        }
    }

}