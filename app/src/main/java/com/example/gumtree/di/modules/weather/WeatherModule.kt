package com.example.gumtree.di.modules.weather

import com.example.gumtree.model.weather.repository.BaseWeatherRepository
import com.example.gumtree.model.weather.repository.WeatherRepository
import com.example.gumtree.presenter.weatherInfo.BaseWeatherPresenter
import com.example.gumtree.presenter.weatherInfo.WeatherPresenter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class WeatherModule {

    @Provides
    @Singleton
    fun provideWeatherEndpoints(retrofit: Retrofit) : WeatherApiService {
        return retrofit.create(WeatherApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherPresenter(weatherRepository: WeatherRepository): BaseWeatherPresenter {
        return WeatherPresenter(weatherRepository)
    }
}