package com.sunnyweather.android.logic.network

import com.sunnyweather.android.SunnyWeatherApplication
import com.sunnyweather.android.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 项目名称：SunnyWeather
 * 类 名 称：PlaceService
 * 类 描 述：城市搜索API接口
 * 创建时间：2020/9/3 14:49
 * 创 建 人：akisora
 */
interface PlaceService {
    @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query : String) : Call<PlaceResponse>
}