package com.sunnyweather.android.logic

import androidx.lifecycle.liveData
import com.sunnyweather.android.logic.model.Weather
import com.sunnyweather.android.logic.network.SunnyWeatherNetWork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.CoroutineContext


/**
 * 项目名称：SunnyWeather
 * 类 名 称：Repository
 * 类 描 述：仓库层--网络接口返回数据解析处理回调类,状态判断ok or false
 * 创建时间：2020/9/3 17:43
 * 创 建 人：akisora
 */
object Repository {
    fun searchPlaces(query:String) =
        fire(Dispatchers.IO){
                val placeResponse = SunnyWeatherNetWork.searchPlaces(query)
                if (placeResponse.status == "ok"){
                    val places = placeResponse.places
                    Result.success(places)
                }else{
                    Result.failure(RuntimeException("response status is ${placeResponse.status}"))
                }
    }
    fun refreshWeather(lng : String,lat : String) =
        fire(Dispatchers.IO){
            coroutineScope {
                val deferredRealtime = async {
                    SunnyWeatherNetWork.getRealtimeWeather(lng,lat)
                }
                val deferredDaily = async {
                    SunnyWeatherNetWork.getDailyWeather(lng,lat)
                }
                val realtimeResponse =  deferredRealtime.await()
                val dailyResponse = deferredDaily.await()
                if (realtimeResponse.status == "ok" && dailyResponse.status == "ok"){
                    val weather = Weather(realtimeResponse.result.realtime
                        ,dailyResponse.result.daily)
                    Result.success(weather)
                }else{
                    Result.failure(
                        RuntimeException(
                            "realtime response status is ${realtimeResponse.status}"+
                            "daily response status is ${dailyResponse.status}"
                        )
                    )
                }
            }
        }
    private fun <T> fire(context:CoroutineContext,block : suspend () -> Result<T>) =
            liveData<Result<T>>(context) {
                val result = try{
                    block()
                }catch (e:Exception){
                    Result.failure<T>(e)
                }
                emit(result)
            }
//    private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
//        liveData<Result<T>>(context) {
//            val result = try {
//                block()
//            } catch (e: Exception) {
//                Result.failure<T>(e)
//            }
//            emit(result)
//        }
}