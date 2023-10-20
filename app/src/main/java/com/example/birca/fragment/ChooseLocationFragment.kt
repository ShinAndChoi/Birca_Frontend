package com.example.birca.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.birca.MainActivity
import com.example.birca.R
import com.example.birca.base.BaseFragment
import com.example.birca.databinding.FragmentChooseLocationBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class ChooseLocationFragment : BaseFragment<FragmentChooseLocationBinding>(R.layout.fragment_choose_location) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainActivity = activity as MainActivity

        val bottomNav = mainActivity.findViewById<BottomNavigationView>(R.id.bottom_nav)

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
    }

}