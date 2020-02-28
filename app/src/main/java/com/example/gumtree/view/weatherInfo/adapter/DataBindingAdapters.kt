package com.example.gumtree.view.weatherInfo.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.gumtree.di.modules.network.WeatherIcons

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    val iconName = WeatherIcons.map[url]
    val drawableId: Int = imageView.context.resources.getIdentifier("$iconName", "drawable", imageView.context.packageName)
    imageView.setImageResource(drawableId)
}