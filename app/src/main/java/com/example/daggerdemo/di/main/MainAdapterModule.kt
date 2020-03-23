package com.example.daggerdemo.di.main

import com.example.daggerdemo.di.scope.ActivityScope
import com.example.daggerdemo.model.ApiRP
import com.example.daggerdemo.ui.MainAdapter
import dagger.Module
import dagger.Provides


@Module
class MainAdapterModule(val allData: List<ApiRP>) {

    @Provides
    @ActivityScope
    fun provideMainAdapter(): MainAdapter{
        return MainAdapter(allData)
    }
}