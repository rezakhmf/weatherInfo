package com.example.gumtree.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.example.gumtree.R
import com.example.gumtree.view.fragmentFactory.FragmentFactoryWeather
import com.example.gumtree.view.weatherInfo.WeatherInfoFragment
import com.example.gumtree.view.weatherInfo.WeatherInfoViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: WeatherInfoViewModel by viewModels()

        buttonWeatherSearch.setOnClickListener{
            if (editWeatherSearch.text.toString().isNotBlank()) {
                viewModel.cityName.value = editWeatherSearch.text.toString()
                showWeatherInfoFragment()

            } else {
                Toast.makeText(applicationContext,
                    "the search is empty!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showWeatherInfoFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout_result_container, FragmentFactoryWeather.getWeatherInfoFragment(supportFragmentManager),
                WeatherInfoFragment.FRAGMENT_NAME)

        fragmentTransaction.addToBackStack(WeatherInfoFragment.FRAGMENT_NAME)
        fragmentTransaction.commit()
    }
}
