package com.example.gumtree.model.weather.repository

import com.example.gumtree.di.modules.weather.WeatherApiService
import com.example.gumtree.model.weather.WeatherModel
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val weatherApiService: WeatherApiService): BaseWeatherRepository {

    override suspend fun getWeatherByCity(name: String): WeatherModel? {
        return weatherApiService.getWeatherByCity(cityName = name)
    }

    override suspend fun getWeatherByCityLatLon(lat: String, lon: String): WeatherModel? {
        return weatherApiService.getWeatherByCityLatLon(lat = lat, lon = lon)
    }


}