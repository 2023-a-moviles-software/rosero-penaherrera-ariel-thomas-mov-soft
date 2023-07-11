package com.example.universidadfacultades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initEventAgregarFacultad()
        initEventActualizarFacultad()
        initEventEliminarFacultad()
        initEventMostrarUniversidad()
    }
    fun initEventAgregarFacultad(){ //Agregar una facultad
        val btnFirestore = findViewById<Button>(R.id.btn_agregarFacultad)
        btnFirestore.setOnClickListener{
            val intent = Intent(this, FacultadAgregada::class.java)
            startActivity(intent)
        }
    }
    fun initEventActualizarFacultad(){ //Actualizar una facultad
        val btnFirestore = findViewById<Button>(R.id.btn_actualizarFacultad)
        btnFirestore.setOnClickListener{
            val intent = Intent(this, FacultadActualizada::class.java)
            startActivity(intent)
        }
    }
    fun initEventEliminarFacultad(){ //Eliminar una facultad
        val btnFirestore = findViewById<Button>(R.id.btn_eliminarFacultad)
        btnFirestore.setOnClickListener{
            val intent = Intent(this, FacultadEliminada::class.java)
            startActivity(intent)
        }
    }
    fun initEventMostrarUniversidad(){ //Mostrar Universidad
        val btnFirestore = findViewById<Button>(R.id.btn_mostrarUniversidades)
        btnFirestore.setOnClickListener{
            val intent = Intent(this, Universidad::class.java)
            startActivity(intent)
        }
    }

}