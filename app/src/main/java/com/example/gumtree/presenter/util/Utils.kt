package com.example.gumtree.presenter.util

fun String.buildQuery(cityName: String): String = this.replace("city", cityName)