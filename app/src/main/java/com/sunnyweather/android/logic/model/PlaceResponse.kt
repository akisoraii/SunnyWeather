package com.sunnyweather.android.logic.model

import com.google.gson.annotations.SerializedName

/**
 * 项目名称：SunnyWeather
 * 类 名 称：PlaceResponse
 * 类 描 述：接收数据模型
 * 创建时间：2020/9/3 14:31
 * 创 建 人：akisora
 */
data class PlaceResponse(val status : String , val places : List<Place>)

data class Place(val name : String , val location : Location,
            @SerializedName("formatted_address") val address : String)

data class Location(val lng : String , val lat : String)