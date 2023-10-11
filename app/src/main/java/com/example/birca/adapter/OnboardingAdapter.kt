package com.example.birca.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.birca.R
import com.example.birca.model.IdolResponseModel

class OnboardingAdapter(private var idolList : ArrayList<IdolResponseModel>) : RecyclerView.Adapter<OnboardingAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OnboardingAdapter.ViewHolder {
val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_onboarding,parent,false)
    return ViewHolder(view)}

    override fun onBindViewHolder(holder: OnboardingAdapter.ViewHolder, position: Int) {

val item = idolList[position]
    holder.bind(item)
    }

    override fun getItemCount(): Int {
               return idolList.size
    }

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var rv_item_text_idol_korean : TextView = view.findViewById(R.id.rv_item_text_idol_korean)
        var rv_item_text_idol_english : TextView = view.findViewById(R.id.rv_item_text_idol_english)
        var rv_item_image_idol : ImageView = view.findViewById(R.id.rv_item_image_idol)

        fun bind(item : IdolResponseModel) {
          rv_item_text_idol_korean.text = item.koreanName
          rv_item_text_idol_english.text = item.englishName
          Glide.with(itemView.context)
              .load(item.imageUrl)
              .into(rv_item_image_idol)
        }
    }

}