package com.example.crud.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.crud.Album
import com.example.crud.R
import com.google.firebase.firestore.FirebaseFirestore

class AlbumAdapter(private val listaAlbumes: ArrayList<Album>):
    RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>(){

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    class AlbumViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val nombreAlbum: TextView = itemView.findViewById(R.id.tv_titulo_album_2)
        val duracion: TextView = itemView.findViewById(R.id.tv_duracion_album_2)
        val fechaLanzamiento: TextView = itemView.findViewById(R.id.tv_fecha_lanzamiento_2)
        val esLanzamiento : TextView = itemView.findViewById(R.id.tv_es_lanzamiento_album_2)

        val btnEliminarAlbum : Button = itemView.findViewById(R.id.btn_eliminar_album)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list_view_album,
            parent, false)
        return  AlbumViewHolder(itemView, mListener)
    }

    override fun getItemCount(): Int = listaAlbumes.size

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val item = listaAlbumes[position]
        holder.nombreAlbum.text = listaAlbumes[position].titulo
        holder.duracion.text = listaAlbumes[position].duracion.toString()
        holder.fechaLanzamiento.text = listaAlbumes[position].fechaLanzamiento
        holder.esLanzamiento.text = listaAlbumes[position].esLanzamiento.toString()

        holder.btnEliminarAlbum.setOnClickListener {
            val db = FirebaseFirestore.getInstance()
            val activity = it.context as AppCompatActivity
            val builder = AlertDialog.Builder(activity)
            builder.setTitle("Eliminar")
            builder.setMessage("¿Desea eliminar este Álbum?")
            builder.setPositiveButton("Sí"){ dialogInterface, i: Int ->
                val elementoEliminar = db.collection("Album").document(item.id)
                println(item.id)
                db.runBatch {batch ->
                    batch.delete(elementoEliminar)
                }.addOnCompleteListener {
                    Toast.makeText(activity, "¡Album Eliminado!t", Toast.LENGTH_SHORT).show()
                    listaAlbumes.removeAt(position)
                    notifyDataSetChanged()
                }
            }
            builder.setNegativeButton("No"){ dialogInterface, i: Int ->
                println("No se ha eliminado el álbum")
            }
            builder.show()
        }

    }
}