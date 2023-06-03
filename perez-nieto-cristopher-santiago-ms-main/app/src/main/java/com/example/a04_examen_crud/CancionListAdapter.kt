package com.example.a04_examen_crud

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CancionListAdapter(private val canciones: List<Cancion
        >) :
    RecyclerView.Adapter<CancionListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textTitle: TextView = itemView.findViewById(R.id.text_title)
        val textAuthor: TextView = itemView.findViewById(R.id.text_author)
        val textYear: TextView = itemView.findViewById(R.id.text_year)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cancion, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cancion = canciones[position]
        holder.textTitle.text = cancion.title
        holder.textAuthor.text = cancion.author
        holder.textYear.text = cancion.year.toString()
    }

    override fun getItemCount() = canciones.size
}
