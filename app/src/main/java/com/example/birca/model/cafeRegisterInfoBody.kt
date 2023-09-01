package com.example.birca.model

import retrofit2.http.Part

data class cafeRegisterInfoBody(
    var cafeName : String,
    var introduction : String,
    var address : String,
    var contact : String,
)
