package com.example.deber.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deber.KfcUsuario
import com.example.deber.R

class KfcUsuarioAdapter(private val kfcUsuariosLista:List<KfcUsuario>):RecyclerView.Adapter<KfcUsuarioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KfcUsuarioViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return KfcUsuarioViewHolder(layoutInflater.inflate(R.layout.item_kfc_usuario, parent, false))
    }

    override fun onBindViewHolder(holder: KfcUsuarioViewHolder, position: Int) {
        val item = kfcUsuariosLista[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = kfcUsuariosLista.size
}