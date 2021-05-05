package com.bintang.tripapp.model

data class ResponseServer(var status: String, var totalResults: Int, val articles: List<Berita>)

data class Berita(
    var author: String,
    var title: String,
    var description: String,
    var url: String,
    var urlToImage: String,
    var publishedAt: String,
    var content: String
)
