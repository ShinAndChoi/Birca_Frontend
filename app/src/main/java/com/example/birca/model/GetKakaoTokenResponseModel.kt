package com.example.birca.model

data class GetKakaoTokenResponseModel(
    val nickname : String,
    val email : String,
    val accessToken : String,
    val refreshToken : String
    )
