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
import com.example.crud.Cancion
import com.example.crud.R
import com.google.firebase.firestore.FirebaseFirestore

class CancionAdapter(private val listaCanciones: ArrayList<Cancion>) :
    RecyclerView.Adapter<CancionAdapter.CancionViewHolder>() {

    private lateinit var mListener: CancionAdapter.onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    class CancionViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val nombreCancion: TextView = itemView.findViewById(R.id.tv_nombre_cancion_2)
        val artista: TextView = itemView.findViewById(R.id.tv_artista_cancion_2)
        val fechaEstreno: TextView = itemView.findViewById(R.id.tv_fecha_estreno_cancion_2)
        val esEstreno : TextView = itemView.findViewById(R.id.tv_es_estreno_cancion_2)
        
        val btnEliminarCancion : Button = itemView.findViewById(R.id.btn_eliminar_cancion)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CancionViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list_view_canciones,
            parent, false)
        return CancionViewHolder(itemView, mListener)
    }

    override fun getItemCount(): Int = listaCanciones.size

    override fun onBindViewHolder(holder: CancionViewHolder, position: Int) {
        val item = listaCanciones[position]
        holder.nombreCancion.text = listaCanciones[position].nombre
        holder.artista.text = listaCanciones[position].artista
        holder.fechaEstreno.text = listaCanciones[position].fechaEstreno
        holder.esEstreno.text = listaCanciones[position].esEstreno.toString()

        holder.btnEliminarCancion.setOnClickListener {
            val database = FirebaseFirestore.getInstance()
            val actividad = it.context as AppCompatActivity
            val builder = AlertDialog.Builder(actividad)
            builder.setTitle("Eliminar")
            builder.setMessage("Seguro que quiere eliminar esta canción?")
            builder.setPositiveButton("Sí"){ dialogInterface, i: Int ->
                val deleteItem = database.collection("Cancion").document(item.id)
                println(item.id)
                database.runBatch { batch ->
                    batch.delete(deleteItem)
                }.addOnCompleteListener {
                    Toast.makeText(actividad, "¡Se ha eliminado la canción!", Toast.LENGTH_SHORT).show()
                    listaCanciones.removeAt(position)
                    notifyDataSetChanged()
                }
            }
            builder.setNegativeButton("No"){ dialogInterface, i: Int ->
                println("No se ha seleccionado")
            }
            builder.show()
        }
    }
}