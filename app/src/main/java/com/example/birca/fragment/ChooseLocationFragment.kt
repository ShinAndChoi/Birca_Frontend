package com.example.birca.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.birca.FragmentActivity
import com.example.birca.MainActivity
import com.example.birca.R
import com.example.birca.base.BaseFragment
import com.example.birca.databinding.FragmentChooseLocationBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class ChooseLocationFragment : BaseFragment<FragmentChooseLocationBinding>(R.layout.fragment_choose_location) {


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
                addToBackStack(null)
                commit()
            }
        }

        binding.btnGangnam.setOnClickListener {
            binding.btnSelectLocationColor.setTextColor(Color.parseColor("#FFFFFF"))
            binding.btnSelectLocationColor.setBackgroundColor(Color.parseColor("#A1B4FF"))

            binding.btnGangnamColor.setTextColor(Color.parseColor("#FFFFFF"))
            binding.btnGangnamColor.setBackgroundColor(Color.parseColor("#A1B4FF"))
            binding.btnGundaeColor.setTextColor(Color.parseColor("#717171"))
            binding.btnGundaeColor.setBackgroundColor(Color.parseColor("#FFFFFF"))
            binding.btnSeongsuColor.setTextColor(Color.parseColor("#717171"))
            binding.btnSeongsuColor.setBackgroundColor(Color.parseColor("#FFFFFF"))
            binding.btnSinchonColor.setTextColor(Color.parseColor("#717171"))
            binding.btnSinchonColor.setBackgroundColor(Color.parseColor("#FFFFFF"))
            binding.btnHongdaeColor.setTextColor(Color.parseColor("#717171"))
            binding.btnHongdaeColor.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
        binding.btnGundae.setOnClickListener {

            binding.btnSelectLocationColor.setTextColor(Color.parseColor("#FFFFFF"))
            binding.btnSelectLocationColor.setBackgroundColor(Color.parseColor("#A1B4FF"))

            binding.btnGangnamColor.setTextColor(Color.parseColor("#717171"))
            binding.btnGangnamColor.setBackgroundColor(Color.parseColor("#FFFFFF"))
            binding.btnGundaeColor.setTextColor(Color.parseColor("#FFFFFF"))
            binding.btnGundaeColor.setBackgroundColor(Color.parseColor("#A1B4FF"))
            binding.btnSeongsuColor.setTextColor(Color.parseColor("#717171"))
            binding.btnSeongsuColor.setBackgroundColor(Color.parseColor("#FFFFFF"))
            binding.btnSinchonColor.setTextColor(Color.parseColor("#717171"))
            binding.btnSinchonColor.setBackgroundColor(Color.parseColor("#FFFFFF"))
            binding.btnHongdaeColor.setTextColor(Color.parseColor("#717171"))
            binding.btnHongdaeColor.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
        binding.btnSeongsu.setOnClickListener {
            binding.btnSelectLocationColor.setTextColor(Color.parseColor("#FFFFFF"))
            binding.btnSelectLocationColor.setBackgroundColor(Color.parseColor("#A1B4FF"))

            binding.btnGangnamColor.setTextColor(Color.parseColor("#717171"))
            binding.btnGangnamColor.setBackgroundColor(Color.parseColor("#FFFFFF"))
            binding.btnGundaeColor.setTextColor(Color.parseColor("#717171"))
            binding.btnGundaeColor.setBackgroundColor(Color.parseColor("#FFFFFF"))
            binding.btnSeongsuColor.setTextColor(Color.parseColor("#FFFFFF"))
            binding.btnSeongsuColor.setBackgroundColor(Color.parseColor("#A1B4FF"))
            binding.btnSinchonColor.setTextColor(Color.parseColor("#717171"))
            binding.btnSinchonColor.setBackgroundColor(Color.parseColor("#FFFFFF"))
            binding.btnHongdaeColor.setTextColor(Color.parseColor("#717171"))
            binding.btnHongdaeColor.setBackgroundColor(Color.parseColor("#FFFFFF"))

        }
        binding.btnSinchon.setOnClickListener {
            binding.btnSelectLocationColor.setTextColor(Color.parseColor("#FFFFFF"))
            binding.btnSelectLocationColor.setBackgroundColor(Color.parseColor("#A1B4FF"))

            binding.btnGangnamColor.setTextColor(Color.parseColor("#717171"))
            binding.btnGangnamColor.setBackgroundColor(Color.parseColor("#FFFFFF"))
            binding.btnGundaeColor.setTextColor(Color.parseColor("#717171"))
            binding.btnGundaeColor.setBackgroundColor(Color.parseColor("#FFFFFF"))
            binding.btnSeongsuColor.setTextColor(Color.parseColor("#717171"))
            binding.btnSeongsuColor.setBackgroundColor(Color.parseColor("#FFFFFF"))
            binding.btnSinchonColor.setTextColor(Color.parseColor("#FFFFFF"))
            binding.btnSinchonColor.setBackgroundColor(Color.parseColor("#A1B4FF"))
            binding.btnHongdaeColor.setTextColor(Color.parseColor("#717171"))
            binding.btnHongdaeColor.setBackgroundColor(Color.parseColor("#FFFFFF"))

        }
        binding.btnHongdae.setOnClickListener {
            binding.btnSelectLocationColor.setTextColor(Color.parseColor("#FFFFFF"))
            binding.btnSelectLocationColor.setBackgroundColor(Color.parseColor("#A1B4FF"))

            binding.btnGangnamColor.setTextColor(Color.parseColor("#717171"))
            binding.btnGangnamColor.setBackgroundColor(Color.parseColor("#FFFFFF"))
            binding.btnGundaeColor.setTextColor(Color.parseColor("#717171"))
            binding.btnGundaeColor.setBackgroundColor(Color.parseColor("#FFFFFF"))
            binding.btnSeongsuColor.setTextColor(Color.parseColor("#717171"))
            binding.btnSeongsuColor.setBackgroundColor(Color.parseColor("#FFFFFF"))
            binding.btnSinchonColor.setTextColor(Color.parseColor("#717171"))
            binding.btnSinchonColor.setBackgroundColor(Color.parseColor("#FFFFFF"))
            binding.btnHongdaeColor.setTextColor(Color.parseColor("#FFFFFF"))
            binding.btnHongdaeColor.setBackgroundColor(Color.parseColor("#A1B4FF"))

        }
    }

}