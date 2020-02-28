package com.example.gumtree.presenter.weatherInfo

import com.example.gumtree.model.weather.WeatherModel
import com.example.gumtree.model.weather.repository.WeatherRepository
import javax.inject.Inject

class WeatherPresenter @Inject constructor(private val weatherRepository: WeatherRepository) :
    BaseWeatherPresenter {


    override suspend fun getWeatherBy(cityName: String): WeatherModel? {
        return weatherRepository.getWeatherByCity(cityName = cityName)
    }
}