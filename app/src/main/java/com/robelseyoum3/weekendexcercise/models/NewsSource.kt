package com.robelseyoum3.weekendexcercise.models

import com.google.gson.annotations.SerializedName

//Json4Kotlin_Base


data class NewsSource (

	@SerializedName("status") val status : String,
	@SerializedName("totalResults") val totalResults : Int,
	@SerializedName("articles") val articles : List<Articles>
)