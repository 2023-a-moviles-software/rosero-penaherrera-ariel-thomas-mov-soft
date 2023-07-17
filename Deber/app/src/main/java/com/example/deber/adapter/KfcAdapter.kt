package com.example.deber.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deber.KfcLista
import com.example.deber.R

class KfcAdapter(private val kfcLista:List<KfcLista>): RecyclerView.Adapter<KfcViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KfcViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return KfcViewHolder(layoutInflater.inflate(R.layout.item_kfc, parent, false))
    }

    override fun onBindViewHolder(holder: KfcViewHolder, position: Int) {
        val item = kfcLista[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = kfcLista.size
}