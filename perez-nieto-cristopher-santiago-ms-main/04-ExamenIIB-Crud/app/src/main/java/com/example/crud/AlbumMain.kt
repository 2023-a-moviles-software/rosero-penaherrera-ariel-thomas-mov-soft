package com.example.crud

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crud.adapter.AlbumAdapter
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AlbumMain : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var listaAlbumes : ArrayList<Album>
    private var database = Firebase.firestore
    var idAlbum = ""

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_main)

        recyclerView = findViewById(R.id.recycler_albumes)
        recyclerView.layoutManager = LinearLayoutManager(this)

        listaAlbumes = arrayListOf()

        database = FirebaseFirestore.getInstance()

        database.collection("Album").get().addOnSuccessListener {
            if (!it.isEmpty) {
                for (document in it.documents) {
                    val albumItem: Album? = document.toObject(Album::class.java)
                    if (albumItem != null) {
                        albumItem.id = document.id
                        println(albumItem.id)
                        listaAlbumes.add(albumItem)
                    }
                }

                val adapter = AlbumAdapter(listaAlbumes)
                recyclerView.adapter =  adapter
                adapter.setOnItemClickListener(object : AlbumAdapter.onItemClickListener{
                    override fun onItemClick(position: Int) {
                        val idAlbum = listaAlbumes[position].id
                        Toast.makeText(this@AlbumMain, "id $idAlbum", Toast.LENGTH_SHORT).show()
                        val btnEditarAlbum = findViewById<Button>(R.id.btn_editar_album)
                        btnEditarAlbum.setOnClickListener {
                            enviarDatos(ActualizarAlbum::class.java, idAlbum)
                        }
                    }
                })
            }
        }
            .addOnFailureListener {
                Toast.makeText(this,it.toString(), Toast.LENGTH_SHORT).show()
            }

        val btnCrearAlbum = findViewById<Button>(R.id.btn_agregar_album)
        btnCrearAlbum.setOnClickListener {
            irActividad(CrearAlbum::class.java)
        }

    }

    private fun irActividad(
        activity: Class<*>
    ){
        val intent = Intent(this, activity)
        startActivity(intent)
    }

    private fun enviarDatos(activity: Class<*>, id: String) {
        val intent = Intent(this, activity)
        intent.putExtra("id", id)
        startActivity(intent)
    }

}