package com.example.daggerdemo.di

import com.example.daggerdemo.di.scope.AppScope
import com.example.daggerdemo.network.Repository
import dagger.Component
import javax.inject.Singleton


@Component(modules = [ApiModule::class])
@AppScope
interface AppComponent {
    fun getRepository(): Repository
}