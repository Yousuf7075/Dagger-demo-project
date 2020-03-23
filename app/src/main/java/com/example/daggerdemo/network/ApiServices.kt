package com.example.daggerdemo.network

import com.example.daggerdemo.model.ApiRP
import io.reactivex.Flowable
import retrofit2.http.GET

interface ApiServices {

    @GET("repositories")
    fun getApiRP(): Flowable<List<ApiRP>>

}