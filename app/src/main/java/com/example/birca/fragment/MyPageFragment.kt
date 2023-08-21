package com.example.birca.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.birca.R
import com.example.birca.databinding.FragmentMyPageBinding
import com.example.birca.sharedPreference.MyApplication


class MyPageFragment : Fragment() {

    private var _binding: FragmentMyPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMyPageBinding.inflate(inflater, container, false)
        val view = binding.root

        val nickname = MyApplication.preferences.getString("nickname","")
        val email = MyApplication.preferences.getString("email","")


        binding.textNickname.setText(nickname)
        binding.textEmail.setText(email)


        return view
    }


}