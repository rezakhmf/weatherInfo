package com.example.gumtree.di.modules.network

object API {
    const val key: String = "appid=95d190a434083879a6398aafd54d9e73"
    const val baseURL: String = "http://openweathermap.org/api?$key"
    const val timeout: Long = 3000
    var byCityID: String = "?q=city$key"
    var byLatLong: String = "?lat=35&lon=139$key"
    var byZipCode: String = "?zip=zipcode,countrycode$key"
}

object WeatherIcons {
    val map = mapOf("01d" to "clearsky" , "02d" to "fewclouds",
        "03d" to "scatteredclouds", "04d" to "brokenclouds",
        "09d" to "showerrain", "10d" to "rain",
        "11d" to "thunderstorm", "13d" to "snow",
        "50d" to "mist")
}