package com.example.gumtree.presenter.weatherInfo

import android.content.SharedPreferences
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import com.example.gumtree.model.weather.WeatherModel
import com.example.gumtree.view.weatherInfo.WeatherInfoViewModel

interface BaseWeatherPresenter {
    suspend fun getWeatherByCity(name: String): WeatherModel?
    suspend fun getWeatherByCityLatLon(lat: String, lon: String): WeatherModel?
}
