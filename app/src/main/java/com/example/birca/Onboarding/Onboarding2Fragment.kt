package com.example.birca.Onboarding

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.birca.R
import com.example.birca.adapter.OnboardingAdapter
import com.example.birca.base.BaseFragment
import com.example.birca.databinding.FragmentOnboarding1Binding
import com.example.birca.databinding.FragmentOnboarding2Binding
import com.example.birca.viewModel.OnboardingIdolViewModel


class Onboarding2Fragment : Fragment() {

    private var _binding : FragmentOnboarding2Binding?= null
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


        _binding = FragmentOnboarding2Binding.inflate(inflater,container,false)
        val view = binding.root


        viewModel = ViewModelProvider(requireActivity()).get(OnboardingIdolViewModel::class.java)

        onboardingAdapter = OnboardingAdapter(ArrayList())

        binding.rvIdolMember.adapter = onboardingAdapter
        binding.rvIdolMember.layoutManager = GridLayoutManager(context,3)



        var idolGroup = viewModel.myIdolGroup.value.toString()
        Log.d("idolGroup",idolGroup)


        viewModel.getIdolMembers(idolGroup)

        viewModel.idolList.observe(viewLifecycleOwner) {



            onboardingAdapter = OnboardingAdapter(it)
            binding.rvIdolMember.adapter = onboardingAdapter
        }


        //뒤로 가기 버튼
        binding.btnBack.setOnClickListener {
            val onboarding1Fragment = Onboarding1Fragment()
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.frameArea_onBoarding, onboarding1Fragment)
                addToBackStack(null)
                commit()
            }
        }


        return view



    }



}