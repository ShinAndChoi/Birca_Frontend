package com.example.birca.sharedPreference

import android.app.Application
import com.example.birca.BuildConfig
import com.kakao.sdk.common.KakaoSdk

class MyApplication : Application() {
    companion object{
        lateinit var preferences: PreferenceUtil
    }

    override fun onCreate() {
        preferences = PreferenceUtil(applicationContext)
        super.onCreate()

        KakaoSdk.init(this, BuildConfig.KAKAO_NATIVE_APP_KEY)
    }
}