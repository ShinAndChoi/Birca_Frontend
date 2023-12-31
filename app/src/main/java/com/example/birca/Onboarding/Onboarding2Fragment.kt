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

    private var _binding: FragmentOnboarding2Binding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: OnboardingIdolViewModel
    private lateinit var onboardingAdapter: OnboardingAdapter


    var myIdolGroup = ""
    var myIdolMember = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentOnboarding2Binding.inflate(inflater, container, false)
        val view = binding.root


        viewModel = ViewModelProvider(requireActivity()).get(OnboardingIdolViewModel::class.java)

        onboardingAdapter = OnboardingAdapter(ArrayList())

        binding.rvIdolMember.adapter = onboardingAdapter
        binding.rvIdolMember.layoutManager = GridLayoutManager(context, 3)



        myIdolGroup = viewModel.myIdolGroup.value.toString()
        Log.d("idolGroup", myIdolGroup)


        viewModel.getIdolMembers(myIdolGroup)

        viewModel.idolList.observe(viewLifecycleOwner) {


            onboardingAdapter = OnboardingAdapter(it)
            binding.rvIdolMember.adapter = onboardingAdapter

            onboardingAdapter.itemClick = object : OnboardingAdapter.ItemClick {

                override fun onClick(view: View, position: Int) {

                    val idolMemberName =
                        viewModel.idolList.value?.get(position)?.koreanName.toString()


                    viewModel.myIdolmember.value = idolMemberName

                    Log.d("idolMemberName", idolMemberName)


                }
            }
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

        //최애 선택
        binding.btnFavoriteIdol.setOnClickListener {

            myIdolMember = viewModel.myIdolmember.value.toString()

            Log.d("myIdolMember", myIdolMember)


            viewModel.postFavoriteIdol(myIdolMember)

            val onboarding3Fragment = Onboarding3Fragment()
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.frameArea_onBoarding, onboarding3Fragment)
                commit()
            }
        }


        return view


    }


}