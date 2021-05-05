package com.bintang.tripapp.model

import com.bintang.tripapp.constant.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import kotlin.math.log

class ConfigNetwork {
    companion object {
        fun getClient(): OkHttpClient{

            val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
            return client
        }

        fun getRetrofit(): Retrofit{
            var constant = Constant()
            return Retrofit.Builder()
                .baseUrl(constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build()
        }

        fun getService(): ApiService{
            return getRetrofit().create(ApiService::class.java)
        }
    }
}

interface ApiService {
    @GET("top-headlines")
    fun getBerita(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): Call<ResponseServer>
}
