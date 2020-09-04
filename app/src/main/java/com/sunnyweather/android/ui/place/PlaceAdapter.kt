package com.sunnyweather.android.ui.place

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.sunnyweather.android.R
import com.sunnyweather.android.logic.model.Place

/**
 * 项目名称：SunnyWeather
 * 类 名 称：PlaceAdapter
 * 类 描 述：RecyclerView适配器
 * 创建时间：2020/9/4 10:58
 * 创 建 人：akisora
 */
class PlaceAdapter(private val fragment: Fragment,private val placeList: List<Place>) :
    RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    inner class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val placeName : TextView = view.findViewById(R.id.placeName)
        val placeAddress : TextView = view.findViewById(R.id.placeAddress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item,parent,false)
        view.setOnClickListener {

        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = placeList[position]
        holder.placeName.text = place.name
        holder.placeAddress.text = place.address
    }

    override fun getItemCount() = placeList.size
}