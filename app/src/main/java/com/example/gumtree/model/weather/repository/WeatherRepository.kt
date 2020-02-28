package com.example.gumtree.model.weather.repository

import com.example.gumtree.di.modules.weather.WeatherApiService
import com.example.gumtree.model.weather.WeatherModel
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val weatherApiService: WeatherApiService): BaseWeatherRepository {

    override suspend fun getWeatherByCity(cityName: String): WeatherModel? {
        return weatherApiService.getWeatherByCity(cityName = cityName).await()
    }
}