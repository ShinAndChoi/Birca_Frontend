package com.example.birca.Onboarding

import android.graphics.Color
import android.os.Bundle
import android.util.Log
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

        viewModel = ViewModelProvider(requireActivity()).get(OnboardingIdolViewModel::class.java)

        onboardingAdapter = OnboardingAdapter(ArrayList())

        binding.rvIdolGroups.adapter = onboardingAdapter
        binding.rvIdolGroups.layoutManager = GridLayoutManager(context,3)


        viewModel.getIdolGroups()

        viewModel.idolList.observe(viewLifecycleOwner) {
            onboardingAdapter = OnboardingAdapter(it)
            binding.rvIdolGroups.adapter = onboardingAdapter

            onboardingAdapter.itemClick = object : OnboardingAdapter.ItemClick{

                override fun onClick(view: View, position: Int) {

                    val idolGroupName= viewModel.idolList.value?.get(position)?.koreanName.toString()


                    viewModel.myIdolGroup.value = idolGroupName
                    Log.d("idolGroup1",viewModel.myIdolGroup.value!!)

                    Log.d("click", "click")
                    val onboarding2Fragment = Onboarding2Fragment()
                    fragmentManager?.beginTransaction()?.apply {
                        replace(R.id.frameArea_onBoarding, onboarding2Fragment)
                        addToBackStack(null)
                        commit()

//                        viewModel.getIdolMembers(idolGroupName!!)

                    }
                }
            }
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        //전체 버튼 클릭 이벤트
        binding.btnAllText.setOnClickListener{

            btnAll()
        }

        //보이그룹 버튼 클릭 이벤트
        binding.btnBoygroupText.setOnClickListener {

            btnBoygroup()
        }

        //걸그룹 버튼 클릭 이벤트
        binding.btnGirlgroupText.setOnClickListener {

            btnGirlgroup()
        }

        //솔로 버튼 클릭 이벤트
        binding.btnSoloText.setOnClickListener {

             btnSolo()
        }

        //혼성 버튼 클릭 이벤트
        binding.btnGenderText.setOnClickListener {

            btnGender()
        }

    }

    fun btnAll() {
        binding.btnAllText.setBackgroundResource(R.drawable.onboarding_border_selected)
        binding.btnBoygroupText.setBackgroundResource(R.drawable.onbooarding_border)
        binding.btnGirlgroupText.setBackgroundResource(R.drawable.onbooarding_border)
        binding.btnSoloText.setBackgroundResource(R.drawable.onbooarding_border)
        binding.btnGenderText.setBackgroundResource(R.drawable.onbooarding_border)



        binding.btnAllText.setTextColor(Color.parseColor("#FFFFFF"))
        binding.btnBoygroupText.setTextColor(Color.parseColor("#888888"))
        binding.btnGirlgroupText.setTextColor(Color.parseColor("#888888"))
        binding.btnSoloText.setTextColor(Color.parseColor("#888888"))
        binding.btnGenderText.setTextColor(Color.parseColor("#888888"))


        viewModel.getIdolGroups()

        viewModel.idolList.observe(viewLifecycleOwner) {
            onboardingAdapter = OnboardingAdapter(it)
            binding.rvIdolGroups.adapter = onboardingAdapter

            onboardingAdapter.itemClick = object : OnboardingAdapter.ItemClick{

                override fun onClick(view: View, position: Int) {

                    val idolGroupName= viewModel.idolList.value?.get(position)?.koreanName.toString()


                    viewModel.myIdolGroup.value = idolGroupName
                    Log.d("idolGroup1",viewModel.myIdolGroup.value!!)

                    Log.d("click", "click")
                    val onboarding2Fragment = Onboarding2Fragment()
                    fragmentManager?.beginTransaction()?.apply {
                        replace(R.id.frameArea_onBoarding, onboarding2Fragment)
                        addToBackStack(null)
                        commit()

//                        viewModel.getIdolMembers(idolGroupName!!)

                    }
                }
            }
        }

    }

    fun btnBoygroup() {


        binding.btnAllText.setBackgroundResource(R.drawable.onbooarding_border)
        binding.btnBoygroupText.setBackgroundResource(R.drawable.onboarding_border_selected)
        binding.btnGirlgroupText.setBackgroundResource(R.drawable.onbooarding_border)
        binding.btnSoloText.setBackgroundResource(R.drawable.onbooarding_border)
        binding.btnGenderText.setBackgroundResource(R.drawable.onbooarding_border)

        binding.btnAllText.setTextColor(Color.parseColor("#888888"))
        binding.btnBoygroupText.setTextColor(Color.parseColor("#FFFFFF"))
        binding.btnGirlgroupText.setTextColor(Color.parseColor("#888888"))
        binding.btnSoloText.setTextColor(Color.parseColor("#888888"))
        binding.btnGenderText.setTextColor(Color.parseColor("#888888"))

//        viewModel = ViewModelProvider(requireActivity()).get(OnboardingIdolViewModel::class.java)

//        onboardingAdapter = OnboardingAdapter(ArrayList())
//
//        binding.rvIdolGroups.adapter = onboardingAdapter
//        binding.rvIdolGroups.layoutManager = GridLayoutManager(context,3)


        viewModel.getIdolGroupsCategory("보이그룹")

        viewModel.idolList.observe(viewLifecycleOwner) {
            onboardingAdapter = OnboardingAdapter(it)
            binding.rvIdolGroups.adapter = onboardingAdapter

            onboardingAdapter.itemClick = object : OnboardingAdapter.ItemClick{

                override fun onClick(view: View, position: Int) {

                    val idolGroupName= viewModel.idolList.value?.get(position)?.koreanName.toString()


                    viewModel.myIdolGroup.value = idolGroupName
                    Log.d("idolGroup1",viewModel.myIdolGroup.value!!)

                    Log.d("click", "click")
                    val onboarding2Fragment = Onboarding2Fragment()
                    fragmentManager?.beginTransaction()?.apply {
                        replace(R.id.frameArea_onBoarding, onboarding2Fragment)
                        addToBackStack(null)
                        commit()

//                        viewModel.getIdolMembers(idolGroupName!!)

                    }
                }
            }
        }


    }

    fun btnGirlgroup() {

        binding.btnAllText.setBackgroundResource(R.drawable.onbooarding_border)
        binding.btnBoygroupText.setBackgroundResource(R.drawable.onbooarding_border)
        binding.btnGirlgroupText.setBackgroundResource(R.drawable.onboarding_border_selected)
        binding.btnSoloText.setBackgroundResource(R.drawable.onbooarding_border)
        binding.btnGenderText.setBackgroundResource(R.drawable.onbooarding_border)

        binding.btnAllText.setTextColor(Color.parseColor("#888888"))
        binding.btnBoygroupText.setTextColor(Color.parseColor("#888888"))
        binding.btnGirlgroupText.setTextColor(Color.parseColor("#FFFFFF"))
        binding.btnSoloText.setTextColor(Color.parseColor("#888888"))
        binding.btnGenderText.setTextColor(Color.parseColor("#888888"))


        viewModel.getIdolGroupsCategory("걸그룹")

        viewModel.idolList.observe(viewLifecycleOwner) {
            onboardingAdapter = OnboardingAdapter(it)
            binding.rvIdolGroups.adapter = onboardingAdapter

            onboardingAdapter.itemClick = object : OnboardingAdapter.ItemClick{

                override fun onClick(view: View, position: Int) {

                    val idolGroupName= viewModel.idolList.value?.get(position)?.koreanName.toString()


                    viewModel.myIdolGroup.value = idolGroupName
                    Log.d("idolGroup1",viewModel.myIdolGroup.value!!)

                    Log.d("click", "click")
                    val onboarding2Fragment = Onboarding2Fragment()
                    fragmentManager?.beginTransaction()?.apply {
                        replace(R.id.frameArea_onBoarding, onboarding2Fragment)
                        addToBackStack(null)
                        commit()

//                        viewModel.getIdolMembers(idolGroupName!!)

                    }
                }
            }
        }

    }

    fun btnSolo() {

        binding.btnAllText.setBackgroundResource(R.drawable.onbooarding_border)
        binding.btnBoygroupText.setBackgroundResource(R.drawable.onbooarding_border)
        binding.btnGirlgroupText.setBackgroundResource(R.drawable.onbooarding_border)
        binding.btnSoloText.setBackgroundResource(R.drawable.onboarding_border_selected)
        binding.btnGenderText.setBackgroundResource(R.drawable.onbooarding_border)

        binding.btnAllText.setTextColor(Color.parseColor("#888888"))
        binding.btnBoygroupText.setTextColor(Color.parseColor("#888888"))
        binding.btnGirlgroupText.setTextColor(Color.parseColor("#888888"))
        binding.btnSoloText.setTextColor(Color.parseColor("#FFFFFF"))
        binding.btnGenderText.setTextColor(Color.parseColor("#888888"))

        viewModel.getIdolGroupsCategory("솔로")

        viewModel.idolList.observe(viewLifecycleOwner) {
            onboardingAdapter = OnboardingAdapter(it)
            binding.rvIdolGroups.adapter = onboardingAdapter

            onboardingAdapter.itemClick = object : OnboardingAdapter.ItemClick{

                override fun onClick(view: View, position: Int) {

                    val idolGroupName= viewModel.idolList.value?.get(position)?.koreanName.toString()


                    viewModel.myIdolGroup.value = idolGroupName
                    Log.d("idolGroup1",viewModel.myIdolGroup.value!!)

                    Log.d("click", "click")
                    val onboarding2Fragment = Onboarding2Fragment()
                    fragmentManager?.beginTransaction()?.apply {
                        replace(R.id.frameArea_onBoarding, onboarding2Fragment)
                        addToBackStack(null)
                        commit()

//                        viewModel.getIdolMembers(idolGroupName!!)

                    }
                }
            }
        }

    }

    fun btnGender() {

        binding.btnAllText.setBackgroundResource(R.drawable.onbooarding_border)
        binding.btnBoygroupText.setBackgroundResource(R.drawable.onbooarding_border)
        binding.btnGirlgroupText.setBackgroundResource(R.drawable.onbooarding_border)
        binding.btnSoloText.setBackgroundResource(R.drawable.onbooarding_border)
        binding.btnGenderText.setBackgroundResource(R.drawable.onboarding_border_selected)

        binding.btnAllText.setTextColor(Color.parseColor("#888888"))
        binding.btnBoygroupText.setTextColor(Color.parseColor("#888888"))
        binding.btnGirlgroupText.setTextColor(Color.parseColor("#888888"))
        binding.btnSoloText.setTextColor(Color.parseColor("#888888"))
        binding.btnGenderText.setTextColor(Color.parseColor("#FFFFFF"))


        viewModel.getIdolGroupsCategory("혼성")

        viewModel.idolList.observe(viewLifecycleOwner) {
            onboardingAdapter = OnboardingAdapter(it)
            binding.rvIdolGroups.adapter = onboardingAdapter

            onboardingAdapter.itemClick = object : OnboardingAdapter.ItemClick{

                override fun onClick(view: View, position: Int) {

                    val idolGroupName= viewModel.idolList.value?.get(position)?.koreanName.toString()


                    viewModel.myIdolGroup.value = idolGroupName
                    Log.d("idolGroup1",viewModel.myIdolGroup.value!!)

                    Log.d("click", "click")
                    val onboarding2Fragment = Onboarding2Fragment()
                    fragmentManager?.beginTransaction()?.apply {
                        replace(R.id.frameArea_onBoarding, onboarding2Fragment)
                        addToBackStack(null)
                        commit()

//                        viewModel.getIdolMembers(idolGroupName!!)

                    }
                }
            }
        }

    }

}