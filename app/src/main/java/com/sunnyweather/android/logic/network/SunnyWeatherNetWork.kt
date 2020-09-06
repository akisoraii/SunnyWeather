package com.sunnyweather.android.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * 项目名称：SunnyWeather
 * 类 名 称：SunnyWeatherNetWork
 * 类 描 述：天气所有api网络请求封装类
 * 创建时间：2020/9/3 16:35
 * 创 建 人：akisora
 */
object SunnyWeatherNetWork {
    //placeService接口封装
    private val placeService = ServiceCreator.create<PlaceService>()
    //查询地区接口
    suspend fun searchPlaces(quary : String) = placeService.searchPlaces(quary).await()

    private suspend fun <T> Call<T>.await() : T {
        return suspendCoroutine {continuation ->
            enqueue(object : Callback<T>{
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null){
                        continuation.resume(body)
                    }else continuation.resumeWithException(
                        RuntimeException("response body is NULL")
                    )
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

            }
            )
        }
    }
    //weatherService接口封装
    private val weatherService = ServiceCreator.create<WeatherService>()
    //获取实况天气接口
    suspend fun getRealtimeWeather(lng : String,lat : String)
            = weatherService.getRealtimeWeather(lng,lat).await()
    //获取每日天气接口
    suspend fun getDailyWeather(lng : String,lat : String)
            = weatherService.getDailyWeather(lng,lat).await()
}