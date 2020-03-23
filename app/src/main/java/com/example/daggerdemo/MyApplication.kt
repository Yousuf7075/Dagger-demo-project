package com.example.daggerdemo

import android.app.Application
import com.example.daggerdemo.di.ApiModule
import com.example.daggerdemo.di.AppComponent
import com.example.daggerdemo.di.DaggerAppComponent
import com.example.daggerdemo.network.Repository

class MyApplication: Application() {
    private lateinit var appComponent: AppComponent
    lateinit var repository: Repository

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().apiModule(ApiModule()).build()
    }

    fun getComponent(): AppComponent{
        return appComponent
    }

    fun getApiRepository(): Repository{
        return appComponent.getRepository()
    }

}