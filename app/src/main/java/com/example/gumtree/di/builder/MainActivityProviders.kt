package com.example.gumtree.di.builder

import com.example.gumtree.view.weatherInfo.WeatherInfoFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityProviders {
    @ContributesAndroidInjector
    abstract fun provideWeatherInfoFragment(): WeatherInfoFragment
}