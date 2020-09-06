package com.sunnyweather.android.logic.model

/**
 * 项目名称：SunnyWeather
 * 类 名 称：Weather
 * 类 描 述：对Realtime和Daily天气信息模型进行封装
 * 创建时间：2020/9/4 15:26
 * 创 建 人：akisora
 */
data class Weather(val realtime: RealtimeResponse.Realtime,val daily: DailyResponse.Daily)