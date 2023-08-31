package com.example.birca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.birca.adapter.CafeListAdapter
import com.example.birca.databinding.ActivityCafeListBinding
import com.example.birca.model.CafeListRequestModel
import com.example.birca.model.cafeListResponseModel
import com.example.birca.viewModel.CafeListViewModel
import kotlin.math.log

class CafeListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCafeListBinding

    private lateinit var cafeListAdapter: CafeListAdapter

    private lateinit var viewModel : CafeListViewModel

    var idol = ""
    var cafe_location = ""
    var cafe_start_date = ""
    var cafe_end_date = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCafeListBinding.inflate(layoutInflater)

        val view = binding.root

        idol = intent.getStringExtra("idol").toString()
        cafe_start_date = intent.getStringExtra("cafe_start_date").toString()
        cafe_end_date = intent.getStringExtra("cafe_end_date").toString()
        cafe_location = intent.getStringExtra("cafe_location").toString()


        //view 모델에 넘겨줄 query
        val cafeList = CafeListRequestModel(
            idol,
            cafe_start_date,
            cafe_end_date,
            cafe_location,
        )


        Log.d("search info", "$idol $cafe_location $cafe_start_date $cafe_end_date" )
        //임시 카페 배열
//        val cafelist = ArrayList<cafeListResponseModel>()
//        cafelist.add(cafeListResponseModel("A","A",R.drawable.photo))
//        cafelist.add(cafeListResponseModel("b","b",R.drawable.photo))
//        cafelist.add(cafeListResponseModel("c","c",R.drawable.photo))
//        cafelist.add(cafeListResponseModel("d","d",R.drawable.photo))
//
//        cafeListAdapter = CafeListAdapter(cafelist)
//        cafeListAdapter.notifyDataSetChanged()


        viewModel = ViewModelProvider(this).get(CafeListViewModel::class.java)


        cafeListAdapter = CafeListAdapter(ArrayList())
        binding.rvCafeList.adapter = cafeListAdapter
        binding.rvCafeList.layoutManager = LinearLayoutManager(this)

        //카페 리스트 호출
        viewModel.getCafeListSearch(
            cafeList
        )


        viewModel.cafeList.observe(this, {
            result ->
            cafeListAdapter = CafeListAdapter(result)
            binding.rvCafeList.adapter = cafeListAdapter
        }
        )
        setContentView(view)
    }
}