package com.example.gumtree.view

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gumtree.R
import com.example.gumtree.view.fragmentFactory.FragmentFactoryWeather
import com.example.gumtree.view.weatherInfo.WeatherInfoFragment
import com.example.gumtree.view.weatherInfo.WeatherInfoViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: WeatherInfoViewModel by viewModels {viewModelFactory}

    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferencesHandler()
        buttonWeatherSearch.setOnClickListener{
            searchViewHandler(editWeatherSearch.text.toString())
        }
    }

    private fun sharedPreferencesHandler(){
        sharedPreferences = getSharedPreferences(PREF_NAME, PRIVATE_MODE)

        val lastCityNam = sharedPreferences.getString(CITY_NAME, null)
        val lastLanLon = sharedPreferences.getString(LAT_LON, null)

        if(lastCityNam != null) {
            editWeatherSearch.setText(lastCityNam)
            searchViewHandler(lastCityNam)
        } else if(lastLanLon != null) {
            editWeatherSearch.setText(lastLanLon)
            searchViewHandler(lastLanLon)
        }
    }

    private fun searchViewHandler(searchQuery: String) {

        if (searchQuery.isNotBlank()) {

            if (FragmentFactoryWeather.getWeatherInfoFragment(supportFragmentManager).isVisible) {
                removeWeatherInfoFragment()
            }

            supportFragmentManager.executePendingTransactions()

            // For search based on Lat and Lon
            if(searchQuery.contains(",")) {
                val latLon = Pair(searchQuery.split(",")[0], searchQuery.split(",")[1])
                viewModel.cityLatLon.value = latLon
                //Set last lat,lon query
                sharedPreferences
                    .edit()
                    .putString(LAT_LON, searchQuery)
                    .putString(CITY_NAME, null)
                    .apply()

                viewModel.cityLatLon.observe(this, Observer {
                    it?.let { latLon ->
                        showWeatherInfoFragmentBy(lat = latLon.first, lon = latLon.second)
                    }
                })
                // For search based on City
            } else {
                viewModel.cityName.value = searchQuery
                //Set last city query
                sharedPreferences
                    .edit()
                    .putString(CITY_NAME, searchQuery)
                    .putString(LAT_LON, null)
                    .apply()

                viewModel.cityName.observe(this, Observer {
                    it?.let { cityName ->
                        showWeatherInfoFragmentBy(cityName)
                    }
                })

            }

        } else {
            Toast.makeText(applicationContext,
                "the search is empty!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showWeatherInfoFragmentBy(cityName: String) {

        val weatherInfoFragment = FragmentFactoryWeather.getWeatherInfoFragment(supportFragmentManager)
        val bundle = Bundle()
        bundle.putString(CITY, cityName)
        weatherInfoFragment.arguments = bundle

        val fragmentTransaction = supportFragmentManager.beginTransaction()
            .replace(
                R.id.frameLayout_result_container, weatherInfoFragment,
                WeatherInfoFragment.FRAGMENT_NAME)
        fragmentTransaction.commit()
    }

    private fun showWeatherInfoFragmentBy(lat: String, lon: String) {

        val weatherInfoFragment = FragmentFactoryWeather.getWeatherInfoFragment(supportFragmentManager)
        val bundle = Bundle()
        bundle.putString(LAT, lat)
        bundle.putString(LON, lon)
        weatherInfoFragment.arguments = bundle

        val fragmentTransaction = supportFragmentManager.beginTransaction()
            .replace(
                R.id.frameLayout_result_container, weatherInfoFragment,
                WeatherInfoFragment.FRAGMENT_NAME)
        fragmentTransaction.commit()
    }

    private fun removeWeatherInfoFragment() {

        val fragmentTransaction = supportFragmentManager.beginTransaction()
            .remove(FragmentFactoryWeather.getWeatherInfoFragment(supportFragmentManager))
        fragmentTransaction.commit()
    }

    companion object Key {
        const val PRIVATE_MODE = 0
        const val PREF_NAME = "gumtree-takeaway"
        const val CITY_NAME = "gumtree-cityname"
        const val LAT_LON = "gumtree-latlon"
        const val CITY = "city"
        const val LAT = "lat"
        const val LON = "lon"
    }

}
