package com.example.gmail.adapter1

import android.app.Activity
import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gmail.Perfil
import com.example.gmail.R
import com.example.gmail.ui.home.Correo
import com.example.gmail.ui.home.adapter.CorreoViewHolder

class PerfilAdapter(private val perfilesList:List<Perfil>, private val onClickListener:(Perfil) -> Unit) : RecyclerView.Adapter<PerfilViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerfilViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PerfilViewHolder(layoutInflater.inflate(R.layout.item_perfiles, parent, false))
    }

    override fun getItemCount(): Int {
        return perfilesList.size
    }

    override fun onBindViewHolder(holder: PerfilViewHolder, position: Int) {
        val item = perfilesList[position]
        holder.render(item, onClickListener)
    }

}