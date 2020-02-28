package com.example.gumtree.view.weatherInfo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.example.gumtree.BR
import com.example.gumtree.databinding.FragmentSearchResutlItemBinding
import com.example.gumtree.model.weather.WeatherModel
import com.example.gumtree.view.weatherInfo.DataBindingViewHolder

class WeatherInfoAdapter(private var items: ArrayList<WeatherModel> = arrayListOf()) :
    androidx.recyclerview.widget.RecyclerView.Adapter<WeatherInfoAdapter.WeatherInfoHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: WeatherInfoHolder, position: Int) {
        holder.onBind(items[position])
        //holder.dataBinding.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherInfoHolder {
        val binding = FragmentSearchResutlItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherInfoHolder(binding)
    }

    inner class WeatherInfoHolder(dataBinding: ViewDataBinding): DataBindingViewHolder<WeatherModel>(dataBinding) {

        override fun onBind(t: WeatherModel): Unit = with(t) {
            dataBinding.setVariable(BR.weatherInfo, t)
        }
    }

    fun add(list: ArrayList<WeatherModel>) {
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

}