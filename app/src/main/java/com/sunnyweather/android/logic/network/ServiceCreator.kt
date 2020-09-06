package com.sunnyweather.android.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 项目名称：SunnyWeather
 * 类 名 称：ServiceCreator
 * 类 描 述：Retrofit构建器头--一劳永逸
 * 创建时间：2020/9/3 15:54
 * 创 建 人：akisora
 */
object ServiceCreator {
    private const val BASE_URL = "https://api.caiyunapp.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass: Class<T>) : T = retrofit.create(serviceClass)
    //泛型实化
    inline fun <reified T>create() : T = create(T::class.java)
}