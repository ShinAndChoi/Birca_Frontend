package com.example.birca.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.birca.R
import com.example.birca.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
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

        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        val view = binding.root


        binding.homeCalendar.setOnDateChangeListener{ view, year, month, dayOfMonth ->


            Log.d("date", "${year}년 ${month}월 ${dayOfMonth}일")
        }

        return view
    }


}