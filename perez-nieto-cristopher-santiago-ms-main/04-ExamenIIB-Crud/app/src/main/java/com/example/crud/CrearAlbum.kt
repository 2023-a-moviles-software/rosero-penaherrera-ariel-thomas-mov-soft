package com.example.crud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CrearAlbum : AppCompatActivity() {
    private var database = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        database = FirebaseFirestore.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_album)

        val tituloAlbum = findViewById<EditText>(R.id.et_crear_titulo_album)
        val duracion = findViewById<EditText>(R.id.et_crear_duracion_album)
        val fechaLanzamiento = findViewById<EditText>(R.id.et_crear_fecha_lanzamiento_album)
        val esLanzamiento = findViewById<EditText>(R.id.et_crear_es_lanzamiento_album)

        val btnSaveRestaurant = findViewById<Button>(R.id.btn_crear_album)
        btnSaveRestaurant.setOnClickListener {
            if (tituloAlbum.text.isNotEmpty()
                && duracion.text.isNotEmpty()
                && fechaLanzamiento.text.isNotEmpty()
                && esLanzamiento.text.isNotEmpty()
            ){
                val lanzamientoString = esLanzamiento.text.toString()
                val resultadoLanzamiento = lanzamientoString.toBoolean()

                val duracionString = duracion.text.toString()
                val resultadoDuracion = duracionString.toDouble()

                val data = hashMapOf(
                    "titulo" to tituloAlbum.text.toString(),
                    "duracion" to resultadoDuracion,
                    "fechaLanzamiento" to fechaLanzamiento.text.toString(),
                    "esLanzamiento" to resultadoLanzamiento,

                )

                database.collection("Album").add(data).
                addOnSuccessListener {
                    Toast.makeText(this, "¡Se ha creado un album!", Toast.LENGTH_SHORT).show()
                    irActividad(AlbumMain::class.java)
                }.addOnFailureListener {
                    Toast.makeText(this, "Error al crear un album", Toast.LENGTH_SHORT).show()
                    irActividad(AlbumMain::class.java)
                }
            }
        }
    }

    private fun irActividad(activity: Class<*>){
        val intent = Intent(this, activity)
        startActivity(intent)
    }
}