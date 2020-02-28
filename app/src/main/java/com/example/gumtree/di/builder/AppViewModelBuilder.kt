package com.example.gumtree.di.builder

import androidx.lifecycle.ViewModel
import com.example.gumtree.di.qualifier.ViewModelKey
import com.example.gumtree.view.weatherInfo.WeatherInfoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AppViewModelBuilder {
    @Binds
    @IntoMap
    @ViewModelKey(WeatherInfoViewModel::class)
    abstract fun bindWeatherInfoViewModel(weatherInfoViewModel: WeatherInfoViewModel) : ViewModel
}