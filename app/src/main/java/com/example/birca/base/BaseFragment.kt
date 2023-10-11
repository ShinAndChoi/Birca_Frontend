package com.example.birca.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.birca.R

abstract class BaseFragment<T : ViewDataBinding>(@LayoutRes val layoutRes: Int) : Fragment() {

    lateinit var binding : T


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,layoutRes,container,false)

        val view = binding.root


        binding.lifecycleOwner = this@BaseFragment

        return view
    }



}