package com.example.gmail.adapter1

import android.app.Activity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gmail.Perfil
import com.example.gmail.R
import com.example.gmail.databinding.ItemPerfilesBinding

class PerfilViewHolder(view: View) : RecyclerView.ViewHolder(view){
    //val activity: Activity = Activity()
    val binding = ItemPerfilesBinding.bind(view)
/*
    val correoElec = view.findViewById<TextView>(R.id.tv_perfiles)
    val photo = view.findViewById<ImageView>(R.id.iv_perfil_image)
*/
    fun render(perfilModel: Perfil, onClickListener:(Perfil) -> Unit){
        binding.tvPerfiles.text = perfilModel.correoElectronico
        Glide.with(binding.ivPerfilImage.context).load(perfilModel.image).into(binding.ivPerfilImage)
        /*binding.tvPerfiles.setOnClickListener {
            Toast.makeText(
                binding.tvPerfiles.context,
                "hola",
                Toast.LENGTH_SHORT
            ).show()
        }*/
    itemView.setOnClickListener{
        onClickListener(perfilModel)
    }

    }


}