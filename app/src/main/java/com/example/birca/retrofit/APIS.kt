package com.example.birca.retrofit

import com.example.birca.model.GetKakaoTokenResponseModel
import com.example.birca.model.IdolResponseModel
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface APIS {


    //---------------------------refactoring------------------------------

    //카카오 로그인 토큰 보내기
    @POST("token")
    fun getKakaoToken(
        @Query("accessToken") accessToken: String
    ): Call<GetKakaoTokenResponseModel>


    //아이돌 그룹 전체 받아오기
    @GET("idolGroups")
    fun getIdolGroups(
        @Header("Authorization") Authorization: String,
    ): Call<ArrayList<IdolResponseModel>>

    //아이돌 그룹 카테고리별 받아오기
    @GET("idolGroup/search/category")
    fun getIdolGroupsCategory(
        @Header("Authorization") Authorization: String,
        @Query("type") type: String
    ): Call<ArrayList<IdolResponseModel>>

    //아이돌 멤버 받아오기
    @GET("idols")
    fun getIdols(
        @Header("Authorization") Authorization: String,
        @Query("groupName") groupName: String
    ): Call<ArrayList<IdolResponseModel>>

    //최애 아이돌 저장
    @POST("save/favoriteIdol")
    fun postFavoriteIdol(
        @Header("Authorization") Authorization: String,
        @Query("idolName") idolName: String
    ): Call<Unit>

    //카페 사장 정보
    @Multipart
    @POST("save/cafeInform")
    fun postCafeOwnerInfo(
        @Header("Authorization") Authorization: String,
        @Part("ownerName") ownerName: String,
        @Part("cafeName") cafeName: String,
        @Part("contactNumber") contactNumber: String,
        @Part businessLicense: MultipartBody.Part,

        ): Call<Unit>

    //팬 및 카페사장 저장
    @PATCH("updateRoleType")
    fun saveUserRole(
        @Header("Authorization") Authorization: String,
        @Query("roleType") roleType: String
    ): Call<Unit>
}