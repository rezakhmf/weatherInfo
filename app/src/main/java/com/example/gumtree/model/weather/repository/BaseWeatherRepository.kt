package com.example.gumtree.model.weather.repository

import com.example.gumtree.model.weather.WeatherModel

interface BaseWeatherRepository {
    suspend fun getWeatherByCity(cityName: String): WeatherModel?
}