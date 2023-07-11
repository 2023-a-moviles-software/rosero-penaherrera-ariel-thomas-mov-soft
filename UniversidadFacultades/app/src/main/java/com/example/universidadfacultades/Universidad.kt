package com.example.universidadfacultades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Universidad : AppCompatActivity() {
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_universidad)
        this.setTitle("Universidades del Ecuador")
        obtenerFacultades()
    }
    fun obtenerFacultades(){
        val btnFirestore= findViewById<Button>(R.id.btn_buscarUniversidadFacultad)
        btnFirestore.setOnClickListener{
            val nombreUniversidad =findViewById<EditText>(R.id.tv_nombreUniversidadMostrar)
            val listaFacultades = mutableListOf<FacultadDB>()//Lista de documentos de la base de datos
            db.collection(nombreUniversidad.text.toString())
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        val auto :FacultadDB = document.toObject(FacultadDB::class.java)
                        listaFacultades.add(auto)
                    }
                    Log.d( "Datos de Facultades: ", "$listaFacultades")
                }
            // recyclerView RecyclerView de Facultades

            val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewFacultades)
            recyclerView.layoutManager = LinearLayoutManager(this)//this
            val decoration = DividerItemDecoration(this, LinearLayoutManager(this).orientation)// variable para seprar cada item de la lista
            recyclerView.adapter = UniversidadAdapter(listaFacultades)
            recyclerView.setHasFixedSize(true)
            recyclerView.addItemDecoration(decoration)//separador de items

        }

    }
}