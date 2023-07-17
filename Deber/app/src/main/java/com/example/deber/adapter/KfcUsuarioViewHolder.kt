package com.example.deber.adapter

import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.deber.KfcUsuario
import com.example.deber.R

class KfcUsuarioViewHolder(view: View):ViewHolder(view) {

    val kfcUsuario = view.findViewById<TextView>(R.id.tvKfcTitulo)
    val imagen = view.findViewById<ImageView>(R.id.ivKfcUsuario)

    fun render(kfcUsuarioModel: KfcUsuario){
        kfcUsuario.text = kfcUsuarioModel.titulo
        Glide.with(imagen.context).load(kfcUsuarioModel.imagen).into(imagen)

    }
}