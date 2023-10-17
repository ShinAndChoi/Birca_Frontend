package com.example.birca.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.birca.model.IdolResponseModel
import com.example.birca.retrofit.APIS
import com.example.birca.retrofit.RetrofitInstance
import com.example.birca.sharedPreference.MyApplication
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OnboardingIdolViewModel :ViewModel() {

    private lateinit var API : APIS

     var myIdolGroup = MutableLiveData<String>()

    var myIdolmember = MutableLiveData<String>()

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


    //아이돌 그룹 카테고리별 가져오기
    fun getIdolGroupsCategory(a : String) {
        API = RetrofitInstance.retrofitInstance().create(APIS::class.java)

        val accessToken = MyApplication.preferences.getString("accessToken", "")

        viewModelScope.launch {
            try{
                API.getIdolGroupsCategory(accessToken, a).enqueue(
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

    //아이돌 멤버 가져오기
    fun getIdolMembers(a : String) {
        API = RetrofitInstance.retrofitInstance().create(APIS::class.java)

        val accessToken = MyApplication.preferences.getString("accessToken", "")

        viewModelScope.launch {
            try{
                API.getIdols(accessToken,a).enqueue(
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


    //최애 아이돌 저장
    fun postFavoriteIdol(a: String) {
        API = RetrofitInstance.retrofitInstance().create(APIS::class.java)

        val accessToken = MyApplication.preferences.getString("accessToken", "")

        viewModelScope.launch {
            try{
                API.postFavoriteIdol(accessToken,a).enqueue(
                    object : Callback<Unit> {

                        override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                            if (response.isSuccessful) {


                                Log.d("postFavoriteIdol : " , " success , ${response.body().toString()}")
                            } else {

                                Log.d("postFavoriteIdol Response : ", "fail 1 ${response.body().toString()} , ${response.message()}, ${response.errorBody().toString()}")
                            }
                        }

                        override fun onFailure(call: Call<Unit>, t: Throwable) {
                            Log.d("postFavoriteIdol Response : ", " fail 2 , ${t.message.toString()}")
                        }
                    })
            } catch (e:Exception) {
                Log.d("postFavoriteIdol response : ", " fail 3 , ${e.message}")
            }
        }
    }


    fun saveUserRole(a: String) {
        API = RetrofitInstance.retrofitInstance().create(APIS::class.java)

        val accessToken = MyApplication.preferences.getString("accessToken", "")

        viewModelScope.launch {
            try{
                API.saveUserRole(accessToken,a).enqueue(
                    object : Callback<Unit> {

                        override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                            if (response.isSuccessful) {


                                Log.d("saveUserRole : " , " success , ${response.body().toString()}")
                            } else {

                                Log.d("saveUserRole Response : ", "fail 1 ${response.body().toString()} , ${response.message()}, ${response.errorBody().toString()}")
                            }
                        }

                        override fun onFailure(call: Call<Unit>, t: Throwable) {
                            Log.d("saveUserRole Response : ", " fail 2 , ${t.message.toString()}")
                        }
                    })
            } catch (e:Exception) {
                Log.d("saveUserRole response : ", " fail 3 , ${e.message}")
            }
        }
    }
}