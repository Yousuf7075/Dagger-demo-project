package com.example.daggerdemo.base

import android.app.Application
import com.example.daggerdemo.di.AppComponent
import com.example.daggerdemo.di.DaggerAppComponent
import com.example.daggerdemo.di.NetworkModule

class MyApplication: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        this.appComponent = this.intDagger()
    }

    private fun intDagger() = DaggerAppComponent.builder()
        .networkModule(NetworkModule())
        .build()

}