package com.example.birca

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import com.example.birca.model.GetKakaoTokenResponseModel
import com.example.birca.Onboarding.OnboardingActivity
import com.example.birca.retrofit.APIS
import com.example.birca.retrofit.RetrofitInstance
import com.example.birca.sharedPreference.MyApplication
import com.google.android.material.card.MaterialCardView
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var accessToken = ""
    var refreshToken = ""
    var nickname = ""
    var email = ""

    private val APIS = RetrofitInstance.retrofitInstance().create(APIS::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val kakaoLoginBtn = findViewById<MaterialCardView>(R.id.btn_kakao_login)


        //로그인 버튼 클릭
        kakaoLoginBtn.setOnClickListener {
            startKakaoLogin(this)
        }

    }

    fun startKakaoLogin(context: Context) {
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                Log.e(TAG, "카카오계정으로 로그인 실패 1", error)
            } else if (token != null) {
                Log.i(TAG, "카카오계정으로 로그인 성공 ${token.accessToken}")

                getKakaoToken(token.accessToken)


            }
        }

// 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
            UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
                if (error != null) {
                    Log.e(TAG, "카카오톡으로 로그인 실패 2", error)

                    // 사용자가 카카오톡 설치 후 디바이스 권한 요청 화면에서 로그인을 취소한 경우,
                    // 의도적인 로그인 취소로 보고 카카오계정으로 로그인 시도 없이 로그인 취소로 처리 (예: 뒤로 가기)
                    if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                        return@loginWithKakaoTalk
                    }

                    // 카카오톡에 연결된 카카오계정이 없는 경우, 카카오계정으로 로그인 시도
                    UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
                } else if (token != null) {

                    Log.i(TAG, "카카오톡으로 로그인 성공 ${token.accessToken}")


                    Log.d("getKakaoToken", "${token.accessToken}")
                    getKakaoToken(token.accessToken)
                }
            }
        } else {
            UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
        }
    }

    fun getKakaoToken(kakaoToken: String) {
        APIS.getKakaoToken(kakaoToken)
            .enqueue(object : Callback<GetKakaoTokenResponseModel> {

                override fun onResponse(
                    call: Call<GetKakaoTokenResponseModel>,
                    response: Response<GetKakaoTokenResponseModel>
                ) {
                    if (response.isSuccessful) {

                        nickname = response.body()?.nickname.toString()
                        email = response.body()?.email.toString()
                        accessToken = response.body()?.accessToken.toString()
                        refreshToken = response.body()?.refreshToken.toString()


//                        정보 sharedPreference에 저장
                        MyApplication.preferences.setString("nickname", nickname)
                        MyApplication.preferences.setString("email", email)
                        MyApplication.preferences.setString("accessToken", accessToken)
                        MyApplication.preferences.setString("refreshToken", refreshToken)

                        Log.d("GetKakaoTokenResponseModel", response.body().toString())

                        //홈 화면으로 이동
                        val intent = Intent(baseContext, OnboardingActivity::class.java)
//
                        startActivity(intent)
                    } else {
                        Log.d("kakaoLogin", "fail 1")
                    }
                }

                override fun onFailure(call: Call<GetKakaoTokenResponseModel>, t: Throwable) {
                    Log.d("kakaoLogin", "fail 2")
                }
            })
    }
}