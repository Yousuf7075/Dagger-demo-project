package com.example.daggerdemo.network

import com.example.daggerdemo.model.DataRP
import com.google.gson.Gson
import io.reactivex.Flowable
import retrofit2.Retrofit

class Repository(private val gson: Gson,private val retrofit: Retrofit) {
    var apiServices: ApiServices = retrofit.create(ApiServices::class.java)

    fun getApiRP(): Flowable<List<DataRP>>{
        return apiServices.getApiRP()
    }

}