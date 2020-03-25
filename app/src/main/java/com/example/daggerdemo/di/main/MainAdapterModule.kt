package com.example.daggerdemo.di.main

import com.example.daggerdemo.di.scope.ActivityScope
import com.example.daggerdemo.model.DataRP
import com.example.daggerdemo.ui.MainAdapter
import dagger.Module
import dagger.Provides


@Module
class MainAdapterModule() {

    @Provides
    @ActivityScope
    fun provideMainAdapter(): MainAdapter{
        return MainAdapter()
    }
}