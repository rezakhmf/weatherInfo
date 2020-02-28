package com.example.gumtree.presenter.weatherInfo

import com.example.gumtree.model.weather.WeatherModel

interface BaseWeatherPresenter {
    suspend fun getWeatherBy(cityName: String): WeatherModel?
}
