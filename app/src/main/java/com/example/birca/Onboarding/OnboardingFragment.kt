package com.example.birca.Onboarding

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.birca.R
import com.example.birca.base.BaseFragment
import com.example.birca.databinding.FragmentOnboardingBinding
import com.example.birca.viewModel.OnboardingIdolViewModel


class OnboardingFragment : BaseFragment<FragmentOnboardingBinding>(R.layout.fragment_onboarding) {


    private lateinit var viewModel: OnboardingIdolViewModel

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

        viewModel = ViewModelProvider(requireActivity()).get(OnboardingIdolViewModel::class.java)

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
            isSelcted = true


        }

        binding.btnSelect.setOnClickListener {

            if (isSelcted == true) {
                val fragmentOwner = OnboardingCafeOwnerFragment()
                val fragmentFan = Onboarding1Fragment()
                if (who == 1) {
                    viewModel.saveUserRole("cafeOwner")

                } else {
                    viewModel.saveUserRole("normal")

                }

                when (who) {

                    1 -> fragmentManager?.beginTransaction()?.apply {
                        replace(R.id.frameArea_onBoarding, fragmentOwner)
                        commit()

                    }

                    2 -> fragmentManager?.beginTransaction()?.apply {
                        replace(R.id.frameArea_onBoarding, fragmentFan)
                        commit()
                    }
                }
            }

        }
    }
}