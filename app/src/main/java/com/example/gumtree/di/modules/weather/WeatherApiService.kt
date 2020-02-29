package com.example.gumtree.di.modules.weather

import com.example.gumtree.di.modules.network.API
import com.example.gumtree.model.weather.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET(API.PATH)
    suspend fun getWeatherByCity(@Query("appid") apiKey: String = API.KEY, @Query("q") cityName: String) : WeatherModel?
    @GET(API.PATH)
    suspend fun getWeatherByCityLatLon(@Query("appid") apiKey: String = API.KEY, @Query("lat") lat: String, @Query("lon") lon: String) : WeatherModel?
}