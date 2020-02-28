package com.example.gumtree.di.modules.weather

import com.example.gumtree.di.modules.network.API
import com.example.gumtree.model.weather.WeatherModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET(API.baseURL)
    suspend fun getWeatherByCity(@Query("q") cityName: String) : Deferred<WeatherModel?>
}