package com.example.birca.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.birca.model.CafeListRequestModel
import com.example.birca.model.cafeListResponseModel
import com.example.birca.retrofit.APIS
import com.example.birca.retrofit.RetrofitInstance
import com.example.birca.sharedPreference.MyApplication
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CafeListViewModel:ViewModel() {

    private lateinit var API : APIS

    private var _cafeList = MutableLiveData<ArrayList<cafeListResponseModel>>()
    var cafeList : LiveData<ArrayList<cafeListResponseModel>> = _cafeList


    fun getCafeList(searchInfo : CafeListRequestModel) {
        API = RetrofitInstance.retrofitInstance().create(APIS::class.java)

        val accessToken = MyApplication.preferences.getString("accessToken", "")

        viewModelScope.launch {
            try{
                API.getCafeList(accessToken,1,searchInfo).enqueue(
                    object : Callback<ArrayList<cafeListResponseModel>> {

                    override fun onResponse(call: Call<ArrayList<cafeListResponseModel>>, response: Response<ArrayList<cafeListResponseModel>>) {
                        if (response.isSuccessful) {

                            Log.d("cafeListResponseModel : " , response.body().toString())
                        } else {

                            Log.d("cafeListResponseModel Response : ", "Fail 1")
                        }
                    }

                    override fun onFailure(call: Call<ArrayList<cafeListResponseModel>>, t: Throwable) {
                        Log.d("cafeListResponseModel Response : ", t.message.toString())
                    }
                })
            } catch (e:Exception) {
                Log.d("cafeListResponseModel response : ", "Fail 3")
            }
        }

    }
}


