package com.example.birca

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.birca.adapter.CafeListAdapter
import com.example.birca.databinding.CalendarCafeListBinding
import com.example.birca.viewModel.CafeListViewModel

class CalendarListDialog (a : String): DialogFragment() {

    private var _binding : CalendarCafeListBinding? = null
    private val binding get() = _binding!!
    private lateinit var cafeListAdapter: CafeListAdapter
    private lateinit var viewModel : CafeListViewModel

    var selectDate = a
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = CalendarCafeListBinding.inflate(inflater,container,false)
        val view = binding.root


        //배경 투명
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        viewModel = ViewModelProvider(this).get(CafeListViewModel::class.java)

        viewModel.getCafeListCalendar(selectDate)


        //카페 리스트 어댑터연결
        cafeListAdapter = CafeListAdapter(ArrayList())
        binding.rvCalendarCafeList.adapter = cafeListAdapter
        binding.rvCalendarCafeList.layoutManager = LinearLayoutManager(context)


        viewModel.cafeList.observe(viewLifecycleOwner) {
                result ->
            cafeListAdapter = CafeListAdapter(result)
            binding.rvCalendarCafeList.adapter = cafeListAdapter
        }

        return view
    }
}