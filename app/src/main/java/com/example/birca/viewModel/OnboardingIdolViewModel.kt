package com.example.birca.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.birca.model.IdolResponseModel
import com.example.birca.model.cafeListResponseModel
import com.example.birca.retrofit.APIS
import com.example.birca.retrofit.RetrofitInstance
import com.example.birca.sharedPreference.MyApplication
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OnboardingIdolViewModel :ViewModel() {

    private lateinit var API : APIS

    private var _idolList = MutableLiveData<ArrayList<IdolResponseModel>>()
    var idolList : LiveData<ArrayList<IdolResponseModel>> = _idolList

    //아이돌 그룹 가져오기
    fun getIdolGroups() {
        API = RetrofitInstance.retrofitInstance().create(APIS::class.java)

        val accessToken = MyApplication.preferences.getString("accessToken", "")

        viewModelScope.launch {
            try{
                API.getIdolGroups(accessToken).enqueue(
                    object : Callback<ArrayList<IdolResponseModel>> {

                        override fun onResponse(call: Call<ArrayList<IdolResponseModel>>, response: Response<ArrayList<IdolResponseModel>>) {
                            if (response.isSuccessful) {

                                _idolList.value = response.body()

                                Log.d("IdolResponseModel : " , " success , ${response.body().toString()}")
                            } else {

                                Log.d("IdolResponseModel Response : ", "fail 1 ${response.body().toString()} , ${response.message()}, ${response.errorBody().toString()}")
                            }
                        }

                        override fun onFailure(call: Call<ArrayList<IdolResponseModel>>, t: Throwable) {
                            Log.d("IdolResponseModel Response : ", " fail 2 , ${t.message.toString()}")
                        }
                    })
            } catch (e:Exception) {
                Log.d("IdolResponseModel response : ", " fail 3 , ${e.message}")
            }
        }
    }


}