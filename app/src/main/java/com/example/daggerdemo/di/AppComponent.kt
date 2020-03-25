package com.example.daggerdemo.di

import com.example.daggerdemo.di.main.ActivitySubComponent
import com.example.daggerdemo.di.scope.AppScope
import dagger.Component


@Component(modules = [NetworkModule::class])
@AppScope
interface AppComponent {
    fun getActivitySubComponent(): ActivitySubComponent
}