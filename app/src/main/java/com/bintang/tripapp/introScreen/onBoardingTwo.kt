package com.bintang.tripapp.introScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bintang.tripapp.R
import kotlinx.android.synthetic.main.activity_on_boarding_two.*

class onBoardingTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_two)

        btn_next1.setOnClickListener {
            val intent = Intent(this, onBoardingThree::class.java)
            startActivity(intent)
        }
    }
}