package com.example.birca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kakao.sdk.common.util.Utility

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        //keyHash 가져오기
//        var keyHash = Utility.getKeyHash(this)
//        Log.d("keyHash", keyHash)
    }
}