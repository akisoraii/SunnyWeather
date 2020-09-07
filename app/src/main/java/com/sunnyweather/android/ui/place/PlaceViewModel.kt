package com.sunnyweather.android.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sunnyweather.android.logic.Repository
import com.sunnyweather.android.logic.dao.PlaceDao
import com.sunnyweather.android.logic.model.Place

/**
 * 项目名称：SunnyWeather
 * 类 名 称：PlaceViewModel
 * 类 描 述：Place视图模型
 * 创建时间：2020/9/4 9:54
 * 创 建 人：akisora
 */
class PlaceViewModel : ViewModel() {
    private val searchLiveData = MutableLiveData<String>()

    fun savePlace(place:Place) = Repository.savePlace(place)
    fun getSavedPlace() = Repository.getSavedPlace()
    fun isPlaceSaved() = Repository.isPlaceSaved()

    val placeList = ArrayList<Place>()
    val placeLiveData = Transformations.switchMap(searchLiveData){query->
        Repository.searchPlaces(query)
    }
    fun searchPlaces(query:String){
        searchLiveData.value = query
    }
}