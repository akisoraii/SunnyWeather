package com.sunnyweather.android.logic.model

import com.google.gson.annotations.SerializedName

/**
 * 项目名称：SunnyWeather
 * 类 名 称：RealtimeResponse
 * 类 描 述：实况天气信息模型
 * 创建时间：2020/9/4 14:53
 * 创 建 人：akisora
 */
data class RealtimeResponse(val status : String, val result : Result){

data class Result(val  realtime : Realtime)

data class Realtime(val temperature : Float, val skycon : String,
            @SerializedName("air_quality") val airQuality : AirQuality)
data class AirQuality(val aqi : AQI)

data class AQI(val chn : Float)
}