package com.example.birca.retrofit

import com.example.birca.model.CafeListRequestModel
import com.example.birca.model.GetKakaoTokenResponseModel
import com.example.birca.model.cafeListResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface APIS {

    //카카오 로그인 토큰 보내기
    @POST("token")
    fun getKakaoToken (
        @Query("accessToken") accessToken : String
    ) : Call<GetKakaoTokenResponseModel>

    //카페 검색
    @GET("cafes")
    fun getCafeList (
        @Header("Authorization") Authorization : String,
        @Query("page") page: Int,
        @Body CafeListRequestModel : CafeListRequestModel
    ) : Call<ArrayList<cafeListResponseModel>>


}