package com.example.birca

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import com.example.birca.fragment.*
import com.example.birca.sharedPreference.MyApplication
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kakao.sdk.common.util.Utility

class FragmentActivity : AppCompatActivity() {


    val manager = supportFragmentManager



//    val nickname = intent.getStringExtra("nickname")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        //keyHash 가져오기
        var keyHash = Utility.getKeyHash(this)
        Log.d("keyHash", keyHash)

//


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
}