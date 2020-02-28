package com.example.gumtree.view

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonWeatherSearch.setOnClickListener{
            if (editWeatherSearch.text.toString().isNotBlank()) {

                viewModel.cityName.value = editWeatherSearch.text.toString()

                viewModel.cityName.observe(this, Observer {
                    it?.let { cityName ->
                        showWeatherInfoFragment(cityName)

                    }
                })

            } else {
                Toast.makeText(applicationContext,
                    "the search is empty!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showWeatherInfoFragment(cityName: String) {

        val weatherInfoFragment = FragmentFactoryWeather.getWeatherInfoFragment(supportFragmentManager)
        val bundle = Bundle()
        bundle.putString("city_name", cityName)
        weatherInfoFragment.arguments = bundle

        val fragmentTransaction = supportFragmentManager.beginTransaction()
            .replace(
                R.id.frameLayout_result_container, weatherInfoFragment,
                WeatherInfoFragment.FRAGMENT_NAME)

        fragmentTransaction.addToBackStack(WeatherInfoFragment.FRAGMENT_NAME)
        fragmentTransaction.commit()
    }
}
