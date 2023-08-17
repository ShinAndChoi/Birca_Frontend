package com.example.birca.retrofit

import com.example.birca.model.GetKakaoTokenResponseModel
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface APIS {

    //카카오 로그인 토큰 보내기
    @POST("token")
    fun getKakaoToken (
        @Query("accessToken") accessToken : String
    ) : Call<GetKakaoTokenResponseModel>
}