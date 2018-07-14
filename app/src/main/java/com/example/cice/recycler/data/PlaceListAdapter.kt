package com.example.cice.recycler.data

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.cice.recycler.R
import com.example.cice.recycler.modelo.Place

class PlaceListAdapter(private val list: ArrayList<Place>,private val  context: Context): RecyclerView.Adapter<PlaceListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder{
        val view = LayoutInflater.from(context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun  bindItem(place: Place){
            var pais: TextView = itemView.findViewById(R.id.paisID) as TextView
            var ciudad: TextView = itemView.findViewById(R.id.ciudadID) as TextView
            pais.text = place.countryName
            ciudad.text = place.cityName

            itemView.setOnClickListener {
                Toast.makeText(context, place.countryName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}