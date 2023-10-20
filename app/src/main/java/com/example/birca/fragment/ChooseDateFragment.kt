package com.example.birca.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.birca.FragmentActivity
import com.example.birca.MainActivity
import com.example.birca.R
import com.example.birca.base.BaseFragment
import com.example.birca.databinding.FragmentChooseDateBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class ChooseDateFragment : BaseFragment<FragmentChooseDateBinding>(R.layout.fragment_choose_date) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fragmentActivity = activity as FragmentActivity

        val bottomNav = fragmentActivity.findViewById<BottomNavigationView>(R.id.bottom_nav)

        bottomNav.visibility = View.GONE
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            val reservedCafeListFragment = ReservedCafeListFragment()
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.frameArea, reservedCafeListFragment)
//                addToBackStack(null)
                commit()
            }
        }

        
//        binding.calendar.setOnDateChangeListener { calendarView, year, month, dayOfMonth ->
//
//            binding.btnSelectDateColor.setBackgroundColor(Color.parseColor("#A1B4FF"))
//            Toast.makeText(context,"${year}년 ${month+1}월 ${dayOfMonth}일",Toast.LENGTH_SHORT).show()
//        }

    }


}