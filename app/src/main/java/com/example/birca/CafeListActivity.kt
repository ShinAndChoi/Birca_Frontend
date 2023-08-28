package com.example.birca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.birca.adapter.CafeListAdapter
import com.example.birca.databinding.ActivityCafeListBinding
import com.example.birca.model.cafeListResponseModel

class CafeListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCafeListBinding

    private lateinit var cafeListAdapter: CafeListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCafeListBinding.inflate(layoutInflater)

        val view = binding.root


        //임시 카페 배열
        val cafelist = ArrayList<cafeListResponseModel>()
        cafelist.add(cafeListResponseModel("A","A",R.drawable.photo))
        cafelist.add(cafeListResponseModel("b","b",R.drawable.photo))
        cafelist.add(cafeListResponseModel("c","c",R.drawable.photo))
        cafelist.add(cafeListResponseModel("d","d",R.drawable.photo))

        cafeListAdapter = CafeListAdapter(cafelist)
        cafeListAdapter.notifyDataSetChanged()

        binding.rvCafeList.adapter = cafeListAdapter
        binding.rvCafeList.layoutManager = LinearLayoutManager(this)

        setContentView(view)
    }
}