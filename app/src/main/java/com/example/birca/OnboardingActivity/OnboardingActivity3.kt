package com.example.birca.OnboardingActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.birca.R
import com.example.birca.databinding.ActivityOnboarding1Binding
import com.example.birca.databinding.ActivityOnboarding3Binding

class OnboardingActivity3 : AppCompatActivity() {

    private lateinit var binding : ActivityOnboarding3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnboarding3Binding.inflate(layoutInflater)

        val view = binding.root







        setContentView(view)
    }
}