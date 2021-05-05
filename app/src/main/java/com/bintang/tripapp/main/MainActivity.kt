package com.bintang.tripapp.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bintang.tripapp.R
import com.bintang.tripapp.adapter.BeritaAdapter
import com.bintang.tripapp.model.Berita
import com.bintang.tripapp.presenter.BeritaPresenter
import com.bintang.tripapp.view.BeritaView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BeritaView {

    private var presenter : BeritaPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        presenter = BeritaPresenter(this)
        presenter?.getBerita()

        img_profile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
    private fun TampilBerita(articels: List<Berita>?){

        val adapter = articels?.let { BeritaAdapter(it) }
        val listBerita = findViewById<RecyclerView>(R.id.wisatalist)
        listBerita.adapter = adapter
    }

    override fun isSuccess(message: String, articels: List<Berita>) {
        TampilBerita(articels)

    }

    override fun isError(message: String) {
        Toast.makeText(this, "Gagal", Toast.LENGTH_SHORT).show()
    }
}