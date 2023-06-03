package com.example.gmail.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gmail.R
import com.example.gmail.ui.home.Correo

class CorreoAdapter(private val correosList:List<Correo>) : RecyclerView.Adapter<CorreoViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CorreoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CorreoViewHolder(layoutInflater.inflate(R.layout.item_correos, parent, false))
    }

    override fun getItemCount(): Int {
        return correosList.size
    }

    override fun onBindViewHolder(holder: CorreoViewHolder, position: Int) {
        val item = correosList[position]
        holder.render(item)
    }
}