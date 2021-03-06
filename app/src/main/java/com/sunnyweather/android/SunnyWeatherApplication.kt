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
        //临时的TOKEN TAkhjf8d1nlSlspN
        //个人的TOKEN DoV97eTE0pq0Xc5p
        const val TOKEN = "DoV97eTE0pq0Xc5p"
    }
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}