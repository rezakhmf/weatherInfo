package com.example.gumtree.view.fragmentFactory

import com.example.gumtree.view.weatherInfo.WeatherInfoFragment

object FragmentFactoryWeather {

    fun getWeatherInfoFragment(supportFragmentManager: androidx.fragment.app.FragmentManager): WeatherInfoFragment {
        var fragment = supportFragmentManager.findFragmentByTag(WeatherInfoFragment.FRAGMENT_NAME)
        if (fragment == null) {
            fragment = WeatherInfoFragment()
        }
        return fragment as WeatherInfoFragment
    }
}