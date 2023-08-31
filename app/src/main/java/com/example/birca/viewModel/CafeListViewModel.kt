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

    //검색 카페 리스트
    fun getCafeListSearch(searchInfo : CafeListRequestModel) {
        API = RetrofitInstance.retrofitInstance().create(APIS::class.java)

        val accessToken = MyApplication.preferences.getString("accessToken", "")

        viewModelScope.launch {
            try{
                API.getCafeListSearch(accessToken,0,searchInfo).enqueue(
                    object : Callback<ArrayList<cafeListResponseModel>> {

                    override fun onResponse(call: Call<ArrayList<cafeListResponseModel>>, response: Response<ArrayList<cafeListResponseModel>>) {
                        if (response.isSuccessful) {

                            _cafeList.value = response.body()
                            Log.d("cafeListResponseModel : " , " success , ${response.body().toString()}")
                        } else {

                            Log.d("cafeListResponseModel Response : ", "fail 1 ,${searchInfo.toString()} ${response.body().toString()} , ${response.message()}, ${response.errorBody().toString()}")
                        }
                    }

                    override fun onFailure(call: Call<ArrayList<cafeListResponseModel>>, t: Throwable) {
                        Log.d("cafeListResponseModel Response : ", " fail 2 , ${t.message.toString()}")
                    }
                })
            } catch (e:Exception) {
                Log.d("cafeListResponseModel response : ", " fail 3 , ${e.message}")
            }
        }

    }

    //캘린더 카페 리스트
    fun getCafeListCalendar(selectedDate : String) {
        API = RetrofitInstance.retrofitInstance().create(APIS::class.java)

        val accessToken = MyApplication.preferences.getString("accessToken", "")

        viewModelScope.launch {
            try{
                API.getCafeListCalendar(accessToken,selectedDate).enqueue(
                    object : Callback<ArrayList<cafeListResponseModel>> {

                        override fun onResponse(call: Call<ArrayList<cafeListResponseModel>>, response: Response<ArrayList<cafeListResponseModel>>) {
                            if (response.isSuccessful) {

                                _cafeList.value = response.body()
                                Log.d("cafeListResponseModel : " , " success , ${response.body().toString()}")
                            } else {

                                Log.d("cafeListResponseModel Response : ", "fail 1 ,${selectedDate.toString()} ${response.body().toString()} , ${response.message()}, ${response.errorBody().toString()}")
                            }
                        }

                        override fun onFailure(call: Call<ArrayList<cafeListResponseModel>>, t: Throwable) {
                            Log.d("cafeListResponseModel Response : ", " fail 2 , ${t.message.toString()}")
                        }
                    })
            } catch (e:Exception) {
                Log.d("cafeListResponseModel response : ", " fail 3 , ${e.message}")
            }
        }
    }
}


