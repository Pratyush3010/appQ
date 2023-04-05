package com.example.appq

import retrofit2.Call
import retrofit2.http.GET

interface ServiceApi {

    @GET("qfonapp-interview/api.json")

    fun getposts() : Call<Modal>
}