package com.example.daggerdemo.network

import com.example.daggerdemo.model.DataRP
import io.reactivex.Flowable
import retrofit2.http.GET

interface ApiServices {

    @GET("repositories")
    fun getApiRP(): Flowable<List<DataRP>>

}