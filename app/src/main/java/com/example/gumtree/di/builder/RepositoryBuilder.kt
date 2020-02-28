package com.example.gumtree.di.builder

import com.example.gumtree.model.weather.repository.BaseWeatherRepository
import com.example.gumtree.model.weather.repository.WeatherRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryBuilder {

    @Binds
    abstract fun bindsWeatherRepository(weatherRepository: WeatherRepository) : BaseWeatherRepository
}