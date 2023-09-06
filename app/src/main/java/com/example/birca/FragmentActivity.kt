package com.example.birca

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.birca.fragment.*
import com.example.birca.sharedPreference.MyApplication
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kakao.sdk.common.util.Utility

class FragmentActivity : AppCompatActivity() {


    val manager = supportFragmentManager

    private val STORAGE_PERMISSION_CODE = 123 // 권한 요청 코드

//    val nickname = intent.getStringExtra("nickname")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        //keyHash 가져오기
        var keyHash = Utility.getKeyHash(this)
        Log.d("keyHash", keyHash)

//

//        checkPermissionAndOpenGallery()

        val transaction = manager.beginTransaction()

        val HomeFragment = HomeFragment()
        val RegisterFragment = RegisterFragment()
        val SearchFragment = SearchFragment()
        val RentFragment = RentFragment()


        transaction.replace(R.id.frameArea, HomeFragment)
        transaction.addToBackStack(null)
        transaction.commit()






        val bottom_navi_menu = findViewById<BottomNavigationView>(R.id.bottom_nav)

        bottom_navi_menu.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.tab1 -> {
                    val transaction = manager.beginTransaction()
                    transaction.replace(R.id.frameArea, HomeFragment)
//                    transaction.addToBackStack(null)
                    transaction.commit()
                    true
                }
                R.id.tab2 -> {
                    val transaction = manager.beginTransaction()
                    transaction.replace(R.id.frameArea, SearchFragment)
//                    transaction.addToBackStack(null)
                    transaction.commit()
                    true
                }
                R.id.tab3 -> {
                    val transaction = manager.beginTransaction()
                    transaction.replace(R.id.frameArea, RentFragment)
//                    transaction.addToBackStack(null)
                    transaction.commit()
                    true
                }
                R.id.tab4 -> {
                    val transaction = manager.beginTransaction()
                    transaction.replace(R.id.frameArea, RegisterFragment)
//                    transaction.addToBackStack(null)
                    transaction.commit()
                    true
                }
                else ->false
            }
        }
    }

//    private fun checkPermissionAndOpenGallery() {
//        Log.d("checkPermissionAndOpenGallery","start")
//        // 권한이 이미 부여되었는지 확인합니다.
//        if (ContextCompat.checkSelfPermission(
//                this,
//                android.Manifest.permission.READ_EXTERNAL_STORAGE
//            ) == PackageManager.PERMISSION_GRANTED
//        ) {
//            Log.d("checkPermissionAndOpenGallery","openGallery")
//            // 이미 권한이 부여된 경우 앨범 열기 또는 다른 작업 수행
//            openGallery()
//        } else {
//            // 권한이 없는 경우 권한 요청
//            Log.d("checkPermissionAndOpenGallery","requestStoragePermission")
//
//            requestStoragePermission()
//        }
//    }

//    private fun requestStoragePermission() {
//        // 권한에 대한 설명이 필요한 경우 사용자에게 설명을 보여줄 수 있습니다.
//
//        if (ActivityCompat.shouldShowRequestPermissionRationale(
//                this,
//                android.Manifest.permission.READ_EXTERNAL_STORAGE
//            )
//        ) {
//            // 권한에 대한 설명을 사용자에게 보여줄 수 있는 로직을 여기에 추가
//        } else {
//            Log.d("checkPermissionAndOpenGallery","권한 요청")
//
//            // 권한 요청
//            ActivityCompat.requestPermissions(
//                this,
//                arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
//                STORAGE_PERMISSION_CODE
//            )
//        }
//    }

//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//
//        if (requestCode == STORAGE_PERMISSION_CODE) {
//            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                // 권한이 부여된 경우 앨범 열기 또는 다른 작업 수행
//                openGallery()
//            } else {
//                // 권한이 거부된 경우 사용자에게 알림을 표시하거나 다른 조치를 취할 수 있습니다.
//            }
//        }
//    }
//
//    private fun openGallery() {
//       Toast.makeText(this,"openGallery",Toast.LENGTH_SHORT).show()
//    }
}