package com.sunnyweather.android.logic.network

import com.sunnyweather.android.SunnyWeatherApplication
import com.sunnyweather.android.logic.model.DailyResponse
import com.sunnyweather.android.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * 项目名称：SunnyWeather
 * 类 名 称：WeatherService
 * 类 描 述：天气信息-Retrofit接口
 * 创建时间：2020/9/4 15:30
 * 创 建 人：akisora
 */
interface WeatherService  {
    @GET("v2.5/${SunnyWeatherApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Path("lng") lng : String,@Path("lat") lat : String):
            Call<RealtimeResponse>

    @GET("v2.5/${SunnyWeatherApplication.TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng") lng : String,@Path("lat") lat : String):
            Call<DailyResponse>
}