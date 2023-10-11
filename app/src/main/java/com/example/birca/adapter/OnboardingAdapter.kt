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
import com.example.birca.model.IdolResponseModel


class OnboardingAdapter(private var idolList : ArrayList<IdolResponseModel>) : RecyclerView.Adapter<OnboardingAdapter.ViewHolder>() {
     var selectedItemPosition = -1 // 클릭한 아이템의 포지션을 저장할 변수

    interface ItemClick {
        fun onClick(view: View,position: Int)
        // 이미지 뷰의 투명도를 계산하는 로직을 구현하세요

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OnboardingAdapter.ViewHolder {
val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_onboarding,parent,false)
    return ViewHolder(view)}

    override fun onBindViewHolder(holder: OnboardingAdapter.ViewHolder, position: Int) {

val item = idolList[position]
        val imageAlpha = calculateAlpha(position) // 투명도 계산 로직을 적용하세요
        holder.rv_item_image_idol.alpha = if(position==selectedItemPosition) 1.0f else imageAlpha // 이미지 뷰의 투명도 설정
//        holder.itemView.setOnClickListener {
//            // 아이템을 클릭했을 때 클릭한 아이템만 투명도 변경
//            val previousSelectedItemPosition = selectedItemPosition
//            selectedItemPosition = position
//            notifyItemChanged(previousSelectedItemPosition)
//            notifyItemChanged(selectedItemPosition)
//            Log.d("calculateAlpha","calculateAlpha")
//        }
    holder.bind(item)
    }

    override fun getItemCount(): Int {
               return idolList.size
    }


    var itemClick : ItemClick? = null

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


            itemView.setOnClickListener {
                itemClick?.onClick(itemView,adapterPosition)
                val previousSelectedItemPosition = selectedItemPosition
                selectedItemPosition = position
                notifyItemChanged(previousSelectedItemPosition)
                notifyItemChanged(selectedItemPosition)
                Log.d("calculateAlpha","calculateAlpha")
            }
        }
    }
    fun calculateAlpha(position: Int): Float {
        // 여기에 투명도를 계산하는 로직을 추가하세요.
        // 예를 들어, position이나 데이터와 관련된 값에 따라 투명도를 결정할 수 있습니다.

        var alpha = 0.4f


        return alpha // 임의로 0.5로 설정한 예시
    }
}