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

    // Create a LiveData with a String
//    val cityName: MutableLiveData<String> by lazy {
//        MutableLiveData<String>()
//    }

//    val cityName: LiveData<String> = liveData {
//        emit(this.latestValue.toString())
//    }



     val weatherInfo: LiveData<WeatherModel?> = liveData {
        cityName.value?.let {
            Log.d("", it)
            val data = getWeather.getWeatherBy(cityName = it)
            emit(data)
            Log.d(TAG, data.toString())
        }
    }

    init {
       // cityName.value = ""
//        viewModelScope.launch {
//            fun getWeatherInfo(): LiveData<WeatherModel?> {
//                return weatherInfo
//            }
//        }
    }
}