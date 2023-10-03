package com.example.birca.Onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.birca.databinding.ActivityOnboarding2Binding

class OnboardingActivity2 : AppCompatActivity() {

    private lateinit var binding : ActivityOnboarding2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnboarding2Binding.inflate(layoutInflater)

        val view = binding.root







        setContentView(view)
    }
}