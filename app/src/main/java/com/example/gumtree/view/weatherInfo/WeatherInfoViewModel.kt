package com.example.gumtree.view.weatherInfo

import android.util.Log
import androidx.lifecycle.*
import com.example.gumtree.model.weather.WeatherModel
import com.example.gumtree.presenter.weatherInfo.WeatherPresenter
import javax.inject.Inject

class WeatherInfoViewModel @Inject constructor(private val getWeather: WeatherPresenter) :
    ViewModel() {

    private val TAG = WeatherInfoViewModel::class.java.simpleName

    val cityName = MutableLiveData<String>()
    val cityLatLon = MutableLiveData<Pair<String, String>>()

    init {
        Log.d(TAG, "is loaded")
    }

     val weatherInfoByCityName: LiveData<WeatherModel?> = liveData {
        cityName.value?.let {
            val data = getWeather.getWeatherByCity(name = it)
            emit(data)
        }
    }

    val weatherInfoByLatLon: LiveData<WeatherModel?> = liveData {
        cityLatLon.value?.let {
            val data = getWeather.getWeatherByCityLatLon(it.first, it.second)
            emit(data)
        }
    }

}