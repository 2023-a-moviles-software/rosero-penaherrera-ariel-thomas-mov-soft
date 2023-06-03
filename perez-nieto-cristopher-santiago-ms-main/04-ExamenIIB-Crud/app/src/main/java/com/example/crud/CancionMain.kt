package com.example.crud

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crud.adapter.CancionAdapter
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CancionMain : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var listaCanciones: ArrayList<Cancion>
    private var db = Firebase.firestore
    var cancionId = ""

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cancion_main)

        recyclerView = findViewById(R.id.recycler_canciones)
        recyclerView.layoutManager = LinearLayoutManager(this)

        listaCanciones = arrayListOf()

        db = FirebaseFirestore.getInstance()

        db.collection("Cancion").get().addOnSuccessListener {
            if (!it.isEmpty) {
                for (document in it.documents) {
                    val cancionItem: Cancion? = document.toObject(Cancion::class.java)
                    if (cancionItem != null) {
                        cancionItem.id = document.id
                        println(cancionItem.id)
                        listaCanciones.add(cancionItem)
                    }
                }
                val adapter = CancionAdapter(listaCanciones)
                recyclerView.adapter =  adapter
                adapter.setOnItemClickListener(object : CancionAdapter.onItemClickListener{
                    override fun onItemClick(position: Int) {
                        val idCancion = listaCanciones[position].id
                        Toast.makeText(this@CancionMain, "id: $idCancion", Toast.LENGTH_SHORT).show()
                        val btnEditarCancion = findViewById<Button>(R.id.btn_actualizar_cancion)
                        btnEditarCancion.setOnClickListener {
                            enviarDatos(ActualizarCancion::class.java, idCancion)
                        }
                    }
                })
            }
        }
            .addOnFailureListener {
                Toast.makeText(this,it.toString(), Toast.LENGTH_SHORT).show()
            }

        val btnCrearCancion = findViewById<Button>(R.id.btn_agregar_cancion)
        btnCrearCancion.setOnClickListener {
            irActividad(CrearCancion::class.java)
        }
    }

    private fun irActividad(activity: Class<*>){
        val intent = Intent(this, activity)
        startActivity(intent)
    }

    private fun enviarDatos(
        activity: Class<*>,
        id: String
    ) {
        val intent = Intent(this, activity)
        intent.putExtra("id", id)
        startActivity(intent)
    }
}