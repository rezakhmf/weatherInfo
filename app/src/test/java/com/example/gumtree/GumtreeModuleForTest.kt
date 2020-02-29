package com.example.gumtree

import com.example.gumtree.model.weather.repository.WeatherRepository
import com.example.gumtree.presenter.weatherInfo.BaseWeatherPresenter
import com.example.gumtree.presenter.weatherInfo.WeatherPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class GumtreeModuleForTest {

    @Provides
    @Singleton
    fun provideWeatherPresenter(weatherRepository: WeatherRepository): BaseWeatherPresenter {
        return WeatherPresenter(weatherRepository)
    }
}