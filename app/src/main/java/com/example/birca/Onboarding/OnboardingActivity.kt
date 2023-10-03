package com.example.birca.Onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.birca.R
import com.example.birca.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {

    val manager = supportFragmentManager

    private lateinit var binding : ActivityOnboardingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityOnboardingBinding.inflate(layoutInflater)

        val view = binding.root



        val transaction = manager.beginTransaction()


        val onboarding1Fragment = Onboarding1Fragment()

        transaction.replace(R.id.frameArea_onBoarding, onboarding1Fragment)

        transaction.commit()


        setContentView(view)
    }
}