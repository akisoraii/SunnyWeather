package com.sunnyweather.android

import android.app.Application
import android.content.Context

/**
 * 项目名称：SunnyWeather
 * 类 名 称：SunnyWeatherApplication
 * 类 描 述：获取全局Context
 * 创建时间：2020/9/3 14:24
 * 创 建 人：akisora
 */
class SunnyWeatherApplication : Application() {
    companion object{
        lateinit var context : Context
        const val TOKEN = "xxxxxxxxxxxxxx"
    }
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}