package com.example.gumtree.di.modules.network

import android.content.Context
import com.example.gumtree.GumtreeApp
import com.example.gumtree.di.builder.ActivityBuilder
import com.example.gumtree.di.builder.ViewModelBuilder
import com.example.gumtree.di.modules.weather.WeatherModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, WeatherModule::class, ActivityBuilder::class, ViewModelBuilder::class])
class GumtreeModule {

    @Provides
    @Singleton
    fun provideContext(app: GumtreeApp) : Context {
        return app
    }
}