package com.example.gumtree.model.weather

import com.google.gson.annotations.SerializedName

data class Clouds (

	@SerializedName("all") val all : Int?
)