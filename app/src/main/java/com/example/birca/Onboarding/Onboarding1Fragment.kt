package com.example.birca.Onboarding

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.birca.R
import com.example.birca.adapter.OnboardingAdapter
import com.example.birca.databinding.FragmentOnboarding1Binding
import com.example.birca.viewModel.OnboardingIdolViewModel


class Onboarding1Fragment : Fragment() {

    private var _binding :FragmentOnboarding1Binding?= null
    private val binding get() = _binding!!

    private lateinit var viewModel : OnboardingIdolViewModel
    private lateinit var onboardingAdapter: OnboardingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboarding1Binding.inflate(inflater,container,false)
        val view = binding.root

        viewModel = ViewModelProvider(this).get(OnboardingIdolViewModel::class.java)

        onboardingAdapter = OnboardingAdapter(ArrayList())

        binding.rvIdolGroups.adapter = onboardingAdapter
        binding.rvIdolGroups.layoutManager = GridLayoutManager(context,3)


        viewModel.getIdolGroups()

        viewModel.idolList.observe(viewLifecycleOwner, {
            it->
            onboardingAdapter = OnboardingAdapter(it)
            binding.rvIdolGroups.adapter = onboardingAdapter
        })

        //전체 버튼 클릭 이벤트
        binding.btnAllText.setOnClickListener{

            //btnAll()
        }

        //보이그룹 버튼 클릭 이벤트
        binding.btnBoygroupText.setOnClickListener {

            //btnBoygroup()
        }

        //걸그룹 버튼 클릭 이벤트
        binding.btnGirlgroupText.setOnClickListener {

            //btnGirlgroup()
        }

        //솔로 버튼 클릭 이벤트
        binding.btnSoloText.setOnClickListener {

           // btnSolo()
        }

        //혼성 버튼 클릭 이벤트
        binding.btnGenderText.setOnClickListener {

            //btnGender()
        }

        return view
    }

    fun btnAll() {

        binding.btnAllText.setBackgroundColor(Color.parseColor("#000000"))
        binding.btnBoygroupText.setBackgroundColor(Color.parseColor("#FFFFFF"))
        binding.btnGirlgroupText.setBackgroundColor(Color.parseColor("#FFFFFF"))
        binding.btnSoloText.setBackgroundColor(Color.parseColor("#FFFFFF"))
        binding.btnGenderText.setBackgroundColor(Color.parseColor("#FFFFFF"))

        binding.btnAllText.setTextColor(Color.parseColor("#FFFFFF"))
        binding.btnBoygroupText.setTextColor(Color.parseColor("#888888"))
        binding.btnGirlgroupText.setTextColor(Color.parseColor("#888888"))
        binding.btnSoloText.setTextColor(Color.parseColor("#888888"))
        binding.btnGenderText.setTextColor(Color.parseColor("#888888"))



    }

    fun btnBoygroup() {


        binding.btnAllText.setBackgroundColor(Color.parseColor("#FFFFFF"))
        binding.btnBoygroupText.setBackgroundColor(Color.parseColor("#000000"))
        binding.btnGirlgroupText.setBackgroundColor(Color.parseColor("#FFFFFF"))
        binding.btnSoloText.setBackgroundColor(Color.parseColor("#FFFFFF"))
        binding.btnGenderText.setBackgroundColor(Color.parseColor("#FFFFFF"))

        binding.btnAllText.setTextColor(Color.parseColor("#888888"))
        binding.btnBoygroupText.setTextColor(Color.parseColor("#FFFFFF"))
        binding.btnGirlgroupText.setTextColor(Color.parseColor("#888888"))
        binding.btnSoloText.setTextColor(Color.parseColor("#888888"))
        binding.btnGenderText.setTextColor(Color.parseColor("#888888"))



    }

    fun btnGirlgroup() {

        binding.btnAllText.setBackgroundColor(Color.parseColor("#FFFFFF"))
        binding.btnBoygroupText.setBackgroundColor(Color.parseColor("#FFFFFF"))
        binding.btnGirlgroupText.setBackgroundColor(Color.parseColor("#000000"))
        binding.btnSoloText.setBackgroundColor(Color.parseColor("#FFFFFF"))
        binding.btnGenderText.setBackgroundColor(Color.parseColor("#FFFFFF"))

        binding.btnAllText.setTextColor(Color.parseColor("#888888"))
        binding.btnBoygroupText.setTextColor(Color.parseColor("#888888"))
        binding.btnGirlgroupText.setTextColor(Color.parseColor("#FFFFFF"))
        binding.btnSoloText.setTextColor(Color.parseColor("#888888"))
        binding.btnGenderText.setTextColor(Color.parseColor("#888888"))

    }

    fun btnSolo() {

        binding.btnAllText.setBackgroundColor(Color.parseColor("#FFFFFF"))
        binding.btnBoygroupText.setBackgroundColor(Color.parseColor("#FFFFFF"))
        binding.btnGirlgroupText.setBackgroundColor(Color.parseColor("#FFFFFF"))
        binding.btnSoloText.setBackgroundColor(Color.parseColor("#000000"))
        binding.btnGenderText.setBackgroundColor(Color.parseColor("#FFFFFF"))

        binding.btnAllText.setTextColor(Color.parseColor("#888888"))
        binding.btnBoygroupText.setTextColor(Color.parseColor("#888888"))
        binding.btnGirlgroupText.setTextColor(Color.parseColor("#888888"))
        binding.btnSoloText.setTextColor(Color.parseColor("#FFFFFF"))
        binding.btnGenderText.setTextColor(Color.parseColor("#888888"))

    }

    fun btnGender() {

        binding.btnAllText.setBackgroundColor(Color.parseColor("#FFFFFF"))
        binding.btnBoygroupText.setBackgroundColor(Color.parseColor("#FFFFFF"))
        binding.btnGirlgroupText.setBackgroundColor(Color.parseColor("#FFFFFF"))
        binding.btnSoloText.setBackgroundColor(Color.parseColor("#FFFFFF"))
        binding.btnGenderText.setBackgroundColor(Color.parseColor("#000000"))

        binding.btnAllText.setTextColor(Color.parseColor("#888888"))
        binding.btnBoygroupText.setTextColor(Color.parseColor("#888888"))
        binding.btnGirlgroupText.setTextColor(Color.parseColor("#888888"))
        binding.btnSoloText.setTextColor(Color.parseColor("#888888"))
        binding.btnGenderText.setTextColor(Color.parseColor("#FFFFFF"))
        //

    }

}