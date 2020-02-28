package com.example.gumtree.di.builder

import androidx.lifecycle.ViewModelProvider
import com.example.gumtree.view.weatherInfo.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module(includes = [ RepositoryBuilder::class, AppViewModelBuilder::class])
abstract class ViewModelBuilder {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}