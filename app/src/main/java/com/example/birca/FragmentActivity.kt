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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        //keyHash 가져오기
        var keyHash = Utility.getKeyHash(this)
        Log.d("keyHash", keyHash)


        val transaction = manager.beginTransaction()

        val mainFragment = MainFragment()
        val likeFragment = LikeFragment()
        val chattingFragment = ChattingFragment()
        val mypageFragment = MypageFragment()


        transaction.replace(R.id.frameArea, mainFragment)
        transaction.addToBackStack(null)
        transaction.commit()


        val bottom_navi_menu = findViewById<BottomNavigationView>(R.id.bottom_nav)

        bottom_navi_menu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.tab1 -> {
                    val transaction = manager.beginTransaction()
                    transaction.replace(R.id.frameArea, mainFragment)
//                    transaction.addToBackStack(null)
                    transaction.commit()
                    true
                }

                R.id.tab2 -> {
                    val transaction = manager.beginTransaction()
                    transaction.replace(R.id.frameArea, likeFragment)
//                    transaction.addToBackStack(null)
                    transaction.commit()
                    true
                }

                R.id.tab3 -> {
                    val transaction = manager.beginTransaction()
                    transaction.replace(R.id.frameArea, chattingFragment)
//                    transaction.addToBackStack(null)
                    transaction.commit()
                    true
                }

                R.id.tab4 -> {
                    val transaction = manager.beginTransaction()
                    transaction.replace(R.id.frameArea, mypageFragment)
//                    transaction.addToBackStack(null)
                    transaction.commit()
                    true
                }

                else -> false
            }
        }
    }


}