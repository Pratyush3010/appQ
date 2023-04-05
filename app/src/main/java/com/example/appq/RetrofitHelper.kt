package com.example.appq

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    val baseurl = "https://general.63-141-249-130.plesk.page/"

    fun getInstance() : Retrofit {
        return Retrofit.Builder().baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}