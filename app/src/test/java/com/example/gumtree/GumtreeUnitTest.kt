package com.example.gumtree

import com.example.gumtree.model.weather.WeatherModel
import com.example.gumtree.model.weather.repository.WeatherRepository
import com.google.gson.Gson
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import javax.inject.Inject


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

private const val MOCK_WEATHER = "{\"coord\":{\"lon\":-0.13,\"lat\":51.51},\"weather\":[{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09d\"}],\"base\":\"stations\",\"main\":{\"temp\":280.32,\"pressure\":1012,\"humidity\":81,\"temp_min\":279.15,\"temp_max\":281.15},\"visibility\":10000,\"wind\":{\"speed\":4.1,\"deg\":80},\"clouds\":{\"all\":90},\"dt\":1485789600,\"sys\":{\"type\":1,\"id\":5091,\"message\":0.0103,\"country\":\"GB\",\"sunrise\":1485762037,\"sunset\":1485794875},\"id\":2643743,\"name\":\"London\",\"cod\":200}"

@RunWith(JUnit4::class)
class GumtreeUnitTest {

    @Rule
    @JvmField
    var mockitoRule = MockitoJUnit.rule()

    @Inject
    lateinit var weatherInfoRepositoryMock: WeatherRepository

    lateinit var gson: Gson
    lateinit var weatherModel: WeatherModel


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        gson = Gson()
        weatherModel = gson.fromJson(MOCK_WEATHER, WeatherModel::class.java)
    }


    @Test
    fun testWeatherInfoForLondon() = runBlocking {
        /* Given */
       whenever(weatherInfoRepositoryMock.getWeatherByCity("sydney")).thenReturn(weatherModel)

        /* When */

        /* Then */
        Assert.assertEquals(weatherModel.name, "London")
        Assert.assertEquals(weatherModel.id, 300)
        Assert.assertEquals(weatherModel.sys?.country, "GB")
    }

    @Test
    fun testWeatherInfoForFalseLondon() = runBlocking {
        /* Given */
        whenever(weatherInfoRepositoryMock.getWeatherByCity("sydney")).thenReturn(weatherModel)

        /* When */

        /* Then */
        Assert.assertNotEquals(weatherModel.name, "Sydney")
        Assert.assertNotEquals(weatherModel.id, 100)
        Assert.assertEquals(weatherModel.sys?.country, "AU")
    }
}
