package com.example.birca.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.birca.Onboarding.Onboarding1Fragment
import com.example.birca.R
import com.example.birca.base.BaseFragment
import com.example.birca.databinding.FragmentMainBinding


class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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


        //최근 예약 카페 목록
        binding.btnViewMore.setOnClickListener {
            showReservedCafe()
        }

        //대관 가능 카페 목록
        binding.btnViewMore2.setOnClickListener {
            showCanReserveCafe()
        }
    }


    fun showReservedCafe() {
        val reservedCafeListFragment = ReservedCafeListFragment()
        fragmentManager?.beginTransaction()?.apply {
            replace(R.id.frameArea, reservedCafeListFragment)
//            addToBackStack(null)
            commit()
        }

    }

    fun showCanReserveCafe() {

    }
}