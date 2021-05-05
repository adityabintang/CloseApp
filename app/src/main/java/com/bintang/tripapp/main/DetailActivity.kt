package com.bintang.tripapp.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bintang.tripapp.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var nama = intent.getStringExtra("judul")
        var deskripsi = intent.getStringExtra("deskripsi")
        var image = intent.getStringExtra("gambar")

        tvWisataTitle.text = nama
        tvSchedule.text = deskripsi

        Glide.with(this)
            .load(image)
            .into(img_desk)

        btn_kembali.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }
}