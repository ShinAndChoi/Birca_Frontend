package com.example.birca.Onboarding

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.birca.FragmentActivity
import com.example.birca.R
import com.example.birca.base.BaseFragment
import com.example.birca.databinding.FragmentOnboarding3Binding


class Onboarding3Fragment :
    BaseFragment<FragmentOnboarding3Binding>(R.layout.fragment_onboarding3) {


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


        binding.btnStart.setOnClickListener {

            val intent = Intent(context, FragmentActivity::class.java)

            startActivity(intent)
        }
    }

}