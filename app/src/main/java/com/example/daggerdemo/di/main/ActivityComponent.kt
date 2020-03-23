package com.example.daggerdemo.di.main

import com.example.daggerdemo.ui.MainActivity
import com.example.daggerdemo.di.AppComponent
import com.example.daggerdemo.di.scope.ActivityScope
import dagger.Component


@Component(dependencies = [AppComponent::class], modules = [MainAdapterModule::class])
@ActivityScope
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}