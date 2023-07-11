package com.example.universidadfacultades

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.universidadfacultades.adapter.UniversidadViewHolder

class UniversidadAdapter(private val carrosList: List<FacultadDB>): RecyclerView.Adapter<UniversidadViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversidadViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UniversidadViewHolder(layoutInflater.inflate(R.layout.items_facultades,parent,false))
    }

    override fun onBindViewHolder(holder: UniversidadViewHolder, position: Int) {
        val item = carrosList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = carrosList.size
}