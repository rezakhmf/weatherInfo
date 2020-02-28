package com.example.gumtree.di.modules.network

object API {
    const val KEY: String = "95d190a434083879a6398aafd54d9e73"
    const val BASE_URL: String = "https://api.openweathermap.org/"
    const val PATH: String = "/data/2.5/weather"
    const val timeout: Long = 3000
//    var byCityID: String = "api?q=city$key"
//    var byLatLong: String = "api?lat=35&lon=139$key"
//    var byZipCode: String = "api?zip=zipcode,countrycode$key"
}

object WeatherIcons {
    val map = mapOf("01d" to "clearsky" , "02d" to "fewclouds",
        "03d" to "scatteredclouds", "04d" to "brokenclouds",
        "09d" to "showerrain", "10d" to "rain",
        "11d" to "thunderstorm", "13d" to "snow",
        "50d" to "mist",
        "01n" to "clearsky" , "02n" to "fewclouds",
        "03n" to "scatteredclouds", "04n" to "brokenclouds",
        "09n" to "showerrain", "10n" to "rain",
        "11n" to "thunderstorm", "13n" to "snow",
        "50n" to "mist")
}