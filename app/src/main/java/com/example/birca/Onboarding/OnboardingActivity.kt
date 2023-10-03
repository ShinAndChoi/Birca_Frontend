package com.example.birca.Onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.birca.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding : ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityOnboardingBinding.inflate(layoutInflater)

        val view = binding.root







        setContentView(view)
    }
}