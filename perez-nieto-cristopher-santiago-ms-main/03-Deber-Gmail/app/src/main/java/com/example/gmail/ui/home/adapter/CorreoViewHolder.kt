package com.example.gmail.ui.home.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gmail.R
import com.example.gmail.ui.home.Correo

class CorreoViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val emisor = view.findViewById<TextView>(R.id.tv_correo_emisor)
    val desc = view.findViewById<TextView>(R.id.tv_correo_desc)
    val cont = view.findViewById<TextView>(R.id.tv_correo_cont)
    val photo = view.findViewById<ImageView>(R.id.iv_correo_image)
    fun render(correoModel: Correo){
        emisor.text = correoModel.emisor
        desc.text = correoModel.description
        cont.text = correoModel.content
        Glide.with(photo.context).load(correoModel.photo).into(photo)
    }
}