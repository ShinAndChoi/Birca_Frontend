package com.example.birca.Onboarding

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.birca.R
import com.example.birca.base.BaseFragment
import com.example.birca.databinding.FragmentOnboardingBinding


class OnboardingFragment : BaseFragment<FragmentOnboardingBinding>(R.layout.fragment_onboarding) {



    var who = 0

    var isSelcted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return super.onCreateView(inflater, container, savedInstanceState)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCafeOwner.setOnClickListener {
            who = 1
            binding.btnCafeOwnerColor.setBackgroundColor(Color.parseColor("#A1B4FF"))
            binding.btnCafeFanColor.setBackgroundColor(Color.parseColor("#FFFFFF"))
            binding.btnSelectColor.setBackgroundColor(Color.parseColor("#A1B4FF"))
            isSelcted = true
        }

        binding.btnCafeFan.setOnClickListener {
            who = 2
            binding.btnCafeOwnerColor.setBackgroundColor(Color.parseColor("#FFFFFF"))
            binding.btnCafeFanColor.setBackgroundColor(Color.parseColor("#A1B4FF"))
            binding.btnSelectColor.setBackgroundColor(Color.parseColor("#A1B4FF"))
            isSelcted  = true

        }

        binding.btnSelect.setOnClickListener {

            if(isSelcted==true) {
                val fragmentOwner = OnboardingCafeOwnerFragment()
                val fragmentFan = Onboarding1Fragment()
                when(who) {

                    1 ->  fragmentManager?.beginTransaction()?.apply {
                        replace(R.id.frameArea_onBoarding,fragmentOwner)
                        commit()

                    }

                    2 ->  fragmentManager?.beginTransaction()?.apply {
                        replace(R.id.frameArea_onBoarding,fragmentFan)
                        commit()
                    }
                }
            }

        }
    }
}