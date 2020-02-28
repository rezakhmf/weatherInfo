package com.example.gumtree.model.weather

import com.google.gson.annotations.SerializedName

data class Coord (

	@SerializedName("lon") val lon : Double,
	@SerializedName("lat") val lat : Double
)