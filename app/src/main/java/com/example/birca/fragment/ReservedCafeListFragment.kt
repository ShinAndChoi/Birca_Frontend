package com.example.birca.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.birca.R
import com.example.birca.adapter.CafeListAdapter
import com.example.birca.base.BaseFragment
import com.example.birca.databinding.FragmentOnboarding1Binding
import com.example.birca.databinding.FragmentReservedCafeListBinding
import com.example.birca.model.CafeListResponseModel


class ReservedCafeListFragment : Fragment() {

    private var _binding: FragmentReservedCafeListBinding? = null
    private val binding get() = _binding!!

    private lateinit var cafeListAdapter: CafeListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentReservedCafeListBinding.inflate(inflater,container,false)
        val view = binding.root
        var textList = ArrayList<CafeListResponseModel>()
        textList.add(CafeListResponseModel("A","A","a"))
        textList.add(CafeListResponseModel("b","b","ab"))

        textList.add(CafeListResponseModel("c","c","c"))

        textList.add(CafeListResponseModel("d","d","d"))


        cafeListAdapter = CafeListAdapter(textList)

        binding.rvCafeList.adapter = cafeListAdapter
        binding.rvCafeList.layoutManager = LinearLayoutManager(requireContext())

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}