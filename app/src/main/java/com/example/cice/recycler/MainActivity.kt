package com.example.cice.recycler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.cice.recycler.data.PlaceListAdapter
import com.example.cice.recycler.modelo.Place
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var adapter: PlaceListAdapter? = null
    private var countryList: ArrayList<Place>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    //Data Arrays
    var countryNameList: Array<String> = arrayOf("Canadá", "USA", "México","Cuba", "España", "Italia", "Alemania")
    var citiesNameList: Array<String> = arrayOf("Toronto", "New York", "Cancún", "La Habana", "Madrid", "Roma", "Berlín")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countryList = ArrayList()
        layoutManager = LinearLayoutManager(this)
        adapter = PlaceListAdapter(countryList!!, this)

        for (i in 0..countryNameList.count() - 1){
            var place: Place = Place()
            place.countryName = countryNameList[i]
            place.cityName = citiesNameList[i]
            countryList?.add(place)
        }

        miRecyclerView.layoutManager = layoutManager
        miRecyclerView.adapter = adapter

    }
}
