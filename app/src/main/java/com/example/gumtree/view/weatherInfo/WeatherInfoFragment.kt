package com.example.gumtree.view.weatherInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.gumtree.R
import com.example.gumtree.model.weather.WeatherModel
import com.example.gumtree.view.weatherInfo.adapter.WeatherInfoAdapter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_search_result_rv.*
import javax.inject.Inject

class WeatherInfoFragment: DaggerFragment() {

    private val TAG: String = WeatherInfoFragment::class.java.simpleName

    companion object {
        val FRAGMENT_NAME: String = WeatherInfoFragment::class.java.name
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: WeatherInfoViewModel by viewModels { viewModelFactory }

    val adapter: WeatherInfoAdapter by lazy { WeatherInfoAdapter(arrayListOf())}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search_result_rv, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewModel) {
            weatherInfo.observe(viewLifecycleOwner, Observer {
                initView(it)
            })
        }
    }

    private fun initView(it: WeatherModel?) {
        rv_search_weather_info.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rv_search_weather_info.adapter = adapter
        it?.let { _weather ->
            if(it.name?.isNotEmpty()!!) {
                adapter.clear()
                adapter.add(arrayListOf(_weather))
            } else {
                Toast.makeText(context, context?.getString(R.string.empty_list), android.widget.Toast.LENGTH_LONG).show()
            }
        }
    }
}