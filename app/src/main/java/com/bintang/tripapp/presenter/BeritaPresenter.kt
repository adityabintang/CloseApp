package com.bintang.tripapp.presenter

import android.util.Log
import com.bintang.tripapp.model.ConfigNetwork
import com.bintang.tripapp.model.ResponseServer
import com.bintang.tripapp.view.BeritaView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BeritaPresenter(val beritaView: BeritaView) {
    fun getBerita(){

        ConfigNetwork.getService().getBerita(country = "id", category = "business", apiKey = "f30ca55c322a48fa9e78d49381d67d17")
            .enqueue(object : Callback<ResponseServer>{
                override fun onResponse(
                    call: Call<ResponseServer>,
                    response: Response<ResponseServer>
                ) {
                    if (response.isSuccessful){
                        val articels = response.body()?.articles
                        if (articels?.size ?: 0 > 0){
                            response.body()?.articles?.let { beritaView.isSuccess(response.message(), it) }

                        }
                    }else {
                        beritaView.isError(response.message())
                    }
                }

                override fun onFailure(call: Call<ResponseServer>, t: Throwable) {
                    beritaView.isError(t.message ?: "")
                    Log.d("Error Server", t.message.toString())
                }

            })
    }
}