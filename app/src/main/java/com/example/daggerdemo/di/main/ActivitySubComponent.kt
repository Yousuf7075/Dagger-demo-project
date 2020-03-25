package com.example.daggerdemo.di.main

import com.example.daggerdemo.ui.MainActivity
import com.example.daggerdemo.di.AppComponent
import com.example.daggerdemo.di.factory.ViewModelFactoryModule
import com.example.daggerdemo.di.scope.ActivityScope
import dagger.Component
import dagger.Subcomponent


@Subcomponent
    (modules = [MainAdapterModule::class,
    ViewModelFactoryModule::class,
    MainViewModelModule::class])
@ActivityScope
interface ActivitySubComponent {
    fun inject(mainActivity: MainActivity)
}