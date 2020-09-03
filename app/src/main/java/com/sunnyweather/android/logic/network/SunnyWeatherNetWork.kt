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
 * 类 描 述：TODO
 * 创建时间：2020/9/3 16:35
 * 创 建 人：akisora
 */
object SunnyWeatherNetWork {
    //创建placeService接口
    private val placeService = ServiceCreator.create<PlaceService>()

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
}