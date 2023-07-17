package com.example.deber.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.deber.KfcLista
import com.example.deber.R

class KfcViewHolder(view:View): ViewHolder(view) {

    val kfc = view.findViewById<TextView>(R.id.tvKfcNombre)
    val photo = view.findViewById<ImageView>(R.id.ivKfc)

    fun render(kfcListaModel: KfcLista){
        kfc.text = kfcListaModel.kfclista
        Glide.with(photo.context).load(kfcListaModel.photo).into(photo)
    }
}
