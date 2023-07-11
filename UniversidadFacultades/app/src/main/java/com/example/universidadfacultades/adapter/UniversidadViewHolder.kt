package com.example.universidadfacultades.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.universidadfacultades.FacultadDB
import com.example.universidadfacultades.R

class UniversidadViewHolder (view: View): RecyclerView.ViewHolder(view){
    val nombreFacultadn = view.findViewById<TextView>(R.id.itemNombreF)
    val nombreUniversidadn = view.findViewById<TextView>(R.id.itemNombreUniv)
    val carreras = view.findViewById<TextView>(R.id.itemNumCarreras)
    val estudiantes = view.findViewById<TextView>(R.id.itemEstudiantes)
    val docentes = view.findViewById<TextView>(R.id.itemDocentes)

    fun render(universidadModel: FacultadDB){
        nombreFacultadn.text = universidadModel.nombreFacultad
        nombreUniversidadn.text = universidadModel.nombreUniversidad
        carreras.text = universidadModel.numeroCarreras
        estudiantes.text = universidadModel.numeroEstudiantes
        docentes.text = universidadModel.numeroDocentes

    }
}