package com.sunnyweather.android.logic

import androidx.lifecycle.liveData
import com.sunnyweather.android.logic.model.Place
import com.sunnyweather.android.logic.network.SunnyWeatherNetWork
import kotlinx.coroutines.Dispatchers


/**
 * 项目名称：SunnyWeather
 * 类 名 称：Repository
 * 类 描 述：仓库层从网络获取数据
 * 创建时间：2020/9/3 17:43
 * 创 建 人：akisora
 */
object Repository {
    fun searchPlaces(query:String) =
        liveData<Result<List<Place>>>(Dispatchers.IO) {
        val result = try {
            val placeResponse = SunnyWeatherNetWork.searchPlaces(query)
            if (placeResponse.status == "ok"){
                val places = placeResponse.places
                Result.success(places)
            }else{
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        }catch (e:Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}