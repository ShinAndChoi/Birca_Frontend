package com.example.birca.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.birca.CalendarListDialog
import com.example.birca.R
import com.example.birca.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    //인스턴스 선언
//    fun newInstance() : HomeFragment {
//        return HomeFragment()
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        //mypage 클릭
        binding.btnMyPage.setOnClickListener {
            val myPage = MyPageFragment()
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.frameArea,myPage)
                addToBackStack(null)
                commit()
            }
        }

        //달력 클릭
        binding.homeCalendar.setOnDateChangeListener { view, year, month, dayOfMonth ->


//            val dialog = HomeCafeListCustomDialog(requireContext())
//            dialog.showDialog()

            var realMonth = "${month+1}"
            var realDayOfMonth = "${dayOfMonth}"
            var date = ""
            if(month+1<10) {
                realMonth ="0${month+1}"
            }
            if (dayOfMonth<10) {
                realDayOfMonth = "0$dayOfMonth"
            }

            val selectDate = "${year}-${realMonth}-${realDayOfMonth}"
            val dialog = CalendarListDialog(selectDate)
            dialog.show(requireFragmentManager(),"")

            Log.d("date", "${year}년 ${month+1}월 ${dayOfMonth}일")
        }

        return view
    }


}