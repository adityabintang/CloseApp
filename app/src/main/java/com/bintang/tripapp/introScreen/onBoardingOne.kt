package com.bintang.tripapp.introScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bintang.tripapp.R
import com.bintang.tripapp.main.MainActivity
import kotlinx.android.synthetic.main.activity_on_boarding_one.*

class onBoardingOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_one)

        btn_next.setOnClickListener {
            val intent = Intent(this, onBoardingTwo::class.java)
            startActivity(intent)
        }

        btn_skip.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }
}