package com.example.birca.OnboardingActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.birca.databinding.ActivityOnboarding1Binding

class OnboardingActivity1 : AppCompatActivity() {

    private lateinit var binding : ActivityOnboarding1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityOnboarding1Binding.inflate(layoutInflater)

        val view = binding.root







        setContentView(view)
    }
}