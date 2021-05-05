package com.bintang.tripapp.view

import com.bintang.tripapp.model.Berita

interface BeritaView {
    fun isSuccess(message: String, articels: List<Berita>)
    fun isError(message: String)
}