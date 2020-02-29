package com.example.gumtree.model.weather.repository

import com.example.gumtree.model.weather.WeatherModel

interface BaseWeatherRepository {
    suspend fun getWeatherByCity(name: String): WeatherModel?
    suspend fun getWeatherByCityLatLon(lat: String, lon: String): WeatherModel?
}