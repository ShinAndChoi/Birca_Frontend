package com.example.birca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.birca.databinding.ActivityCafeListBinding
import com.example.birca.databinding.ActivityCafeMoreInfoBinding

class CafeMoreInfoActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCafeMoreInfoBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCafeMoreInfoBinding.inflate(layoutInflater)
        val view = binding.root


        setContentView(view)
    }
}