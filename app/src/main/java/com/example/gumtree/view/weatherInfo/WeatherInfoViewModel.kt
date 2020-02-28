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

     val weatherInfo: LiveData<WeatherModel?> = liveData {
        cityName.let { cityName ->
            val data = getWeather.getWeatherBy(cityName = cityName.value.toString())
            emit(data)
            Log.d(TAG, data.toString())
        }
    }

    init {
//        viewModelScope.launch {
//            fun getWeatherInfo(): LiveData<WeatherModel?> {
//                return weatherInfo
//            }
//        }
    }
}