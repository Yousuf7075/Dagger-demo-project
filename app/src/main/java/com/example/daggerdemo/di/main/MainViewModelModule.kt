package com.example.daggerdemo.di.main

import androidx.lifecycle.ViewModel
import com.example.daggerdemo.di.key.ViewModelKey
import com.example.daggerdemo.ui.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun  bindMainViewModel(viewModel : MainViewModel) : ViewModel
}