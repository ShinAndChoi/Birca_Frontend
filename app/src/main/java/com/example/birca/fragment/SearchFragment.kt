package com.example.birca.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import com.example.birca.R
import com.example.birca.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    private var _binding : FragmentSearchBinding? = null
    private val binding get() = _binding!!

    var idol = ""
    var cafe_location = ""
    var cafe_date = ""

    //인스턴스 선언
//    fun newInstance() : SearchFragment {
//        return SearchFragment()
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSearchBinding.inflate(inflater,container,false)
        val view = binding.root


        //장소 선택
        binding.selectCafeLocation.setOnClickListener {

            val popupBase = binding.selectCafeLocation

            var pop = PopupMenu(context,popupBase)

            pop.menuInflater?.inflate(R.menu.cafe_loaction_list,pop.menu)

            pop.show()

            pop.setOnMenuItemClickListener { item->
                when(item.itemId){
                    R.id.hongdae_sinchon ->
                        binding.selectCafeLocation.setText("홍대/신촌")
                    R.id.seongsu_gundae ->
                        binding.selectCafeLocation.setText("성수/건대")
                    R.id.gangnam ->
                        binding.selectCafeLocation.setText("강남")
                }
                false
            }


        }

        //날짜 선택

        binding.selectCafeDateCalendar.setOnDateChangeListener{ view, year, month, dayOfMonth ->

            binding.selectCafeDate.setText("${year}년 ${month+1}월 ${dayOfMonth}일")
            cafe_date = binding.selectCafeDate.text.toString()
            Log.d("selecteddate", "${year}년 ${month+1}월 ${dayOfMonth}일")
        }

        //검색 버튼
        binding.btnSearch.setOnClickListener {

            idol = binding.textIdol.text.toString()
            cafe_location = binding.selectCafeLocation.text.toString()
            cafe_date = binding.selectCafeDate.text.toString()

            Log.d("click", "click")
          if(idol==""){
              Toast.makeText(context, "아이돌을 입력해주세요", Toast.LENGTH_SHORT).show()
          } else {
              //다음 페이지
              Toast.makeText(context, "다음 페이지", Toast.LENGTH_SHORT).show()
          }


        }

        return view
    }




}