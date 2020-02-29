package com.example.gumtree.presenter.weatherInfo

import com.example.gumtree.model.weather.WeatherModel
import com.example.gumtree.model.weather.repository.WeatherRepository
import javax.inject.Inject

class WeatherPresenter @Inject constructor(private val weatherRepository: WeatherRepository) :
    BaseWeatherPresenter {


    override suspend fun getWeatherByCity(name: String): WeatherModel? {
        return weatherRepository.getWeatherByCity(name = name)
    }

    override suspend fun getWeatherByCityLatLon(lat: String, lon: String): WeatherModel? {
        return weatherRepository.getWeatherByCityLatLon(lat = lat, lon = lon)
    }
}