package com.example.birca.retrofit

import com.example.birca.model.CafeListRequestModel
import com.example.birca.model.GetKakaoTokenResponseModel
import com.example.birca.model.cafeListResponseModel
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface APIS {

    //카카오 로그인 토큰 보내기
    @POST("token")
    fun getKakaoToken (
        @Query("accessToken") accessToken : String
    ) : Call<GetKakaoTokenResponseModel>

    //카페 검색
    @GET("cafes")
    fun getCafeListSearch (
        @Header("Authorization") Authorization : String,
        @Query("page") page : Int,
        @Query("address") address : String,
        @Query("idolName") idolName : String,
        @Query("startDate") startDate : String,
        @Query("endDate") endDate : String,
    ) : Call<ArrayList<cafeListResponseModel>>

    //홈 캘린더 클릭
    @GET("cafes/reserved-on")
    fun getCafeListCalendar (
        @Header("Authorization") Authorization : String,
        @Query("selectedDate") selectedDate : String
    ) : Call<ArrayList<cafeListResponseModel>>

    //카페 등록
    @Multipart
    @POST("cafe/register")
    fun postRegisterCafe(
        @Header("Authorization") Authorization : String,
        @Part("cafeName") cafeName : String,
        @Part("introduction") introduction : String,
        @Part("address") address : String,
        @Part("contact") contact : String,
        @Part businessLicense  : List<MultipartBody.Part>,
        @Part cafeImages : List<MultipartBody.Part>,
    )



}