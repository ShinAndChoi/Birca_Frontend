package com.example.birca.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.birca.R
import com.example.birca.databinding.FragmentRentBinding


class RentFragment : Fragment() {

    private var _binding : FragmentRentBinding? = null
    private val binding get() = _binding!!

    //인스턴스 선언
//    fun newInstance() : RentFragment {
//        return RentFragment()
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRentBinding.inflate(inflater,container,false)

        val view = binding.root



        return view
    }


}