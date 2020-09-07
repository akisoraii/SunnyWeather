package com.sunnyweather.android.logic.model

import com.sunnyweather.android.R

/**
 * 项目名称：SunnyWeather
 * 类 名 称：Sky
 * 类 描 述：TODO
 * 创建时间：2020/9/7 9:05
 * 创 建 人：akisora
 */
class Sky(val info : String,val icon : Int,val bg : Int)

private val sky = mapOf(
    "CLEAR_DAY" to Sky("晴", R.drawable.ic_clear_day,R.drawable.bg_clear_day),
    "CLEAR_NIGHT" to Sky("晴", R.drawable.ic_clear_day,R.drawable.bg_clear_day),
    "PARTLY_CLOUDY_DAY" to Sky("多云",R.drawable.ic_partly_cloud_day,R.drawable.bg_partly_cloudy_day),
    "PARTLY_CLOUDY_NIGHT" to Sky("多云",R.drawable.ic_partly_cloud_night,R.drawable.bg_partly_cloudy_night),
    "CLOUDY" to Sky("阴",R.drawable.ic_cloudy,R.drawable.bg_cloudy),
    "WIND" to Sky("大风",R.drawable.ic_cloudy,R.drawable.bg_wind),
    "LIGHT_RAIN" to Sky("小雨",R.drawable.ic_light_rain,R.drawable.bg_rain),
    "MODERATE_RAIN" to Sky("中雨",R.drawable.ic_moderate_rain,R.drawable.bg_rain),
    "HEAVY_RAIN"   to Sky("大雨",R.drawable.ic_heavy_rain,R.drawable.bg_rain),
    "STORM_RAIN" to Sky("暴雨",R.drawable.ic_storm_rain,R.drawable.bg_rain),
    "LIGHT_SNOW" to Sky("小雪",R.drawable.ic_light_snow,R.drawable.bg_snow),
    "MODERATE_SNOW" to Sky("中雪 ",R.drawable.ic_moderate_snow,R.drawable.bg_snow),
    "HEAVY_SNOW" to Sky("大雪",R.drawable.ic_heavy_snow,R.drawable.bg_snow),
    "STORM_SNOW" to Sky("暴雪",R.drawable.ic_heavy_snow,R.drawable.bg_snow),
    "LIGHT_HAZE" to Sky("轻度雾霾",R.drawable.ic_moderate_rain,R.drawable.bg_rain),
    "MODERATE_HAZE" to Sky("中度雾霾",R.drawable.ic_moderate_rain,R.drawable.bg_rain),
    "HEAVY_HAZE" to Sky("重度雾霾",R.drawable.ic_moderate_rain,R.drawable.bg_rain),
    "FOG" to Sky("雾",R.drawable.ic_fog,R.drawable.bg_fog),
    "DUST" to Sky("浮尘",R.drawable.ic_fog,R.drawable.bg_fog)
)

fun getSky(skycon:String):Sky{
    return sky[skycon]?: sky["CLEAR_DAY"]!!
}