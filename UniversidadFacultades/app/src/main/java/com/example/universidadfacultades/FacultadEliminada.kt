package com.example.universidadfacultades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FacultadEliminada : AppCompatActivity() {
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facultad_eliminada)
        this.setTitle("Eliminar facultad")
        initEliminarFacultad()

    }
    fun initEliminarFacultad(){
        val btnFirestore= findViewById<Button>(R.id.btn_buscarIDFacultadEliminar)
        btnFirestore.setOnClickListener {
            val nombreUniversidad =findViewById<EditText>(R.id.tv_nombreUniEliminar)
            val idFacultadEliminar =findViewById<EditText>(R.id.tv_IDFacultadElim)

            db.collection(nombreUniversidad.text.toString()).document(idFacultadEliminar.text.toString()).delete()

        }
    }
}