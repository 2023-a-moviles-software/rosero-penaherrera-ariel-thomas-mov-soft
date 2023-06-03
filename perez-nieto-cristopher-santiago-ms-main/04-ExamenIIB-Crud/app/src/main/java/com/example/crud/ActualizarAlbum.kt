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

class ActualizarAlbum : AppCompatActivity() {
    private var database = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        database = FirebaseFirestore.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_album)

        val bundle = intent.extras
        val albumID = bundle?.getString("id")

        var docRef = albumID?.let { database.collection("Album").document(it) }

        val tituloAlbum = findViewById<EditText>(R.id.et_titulo_album)
        val duracionAlbum = findViewById<EditText>(R.id.et_duracion_album )
        val fechaLanzamiento = findViewById<EditText>(R.id.et_fecha_lanzamiento_album )
        val esLanzamiento = findViewById<EditText>(R.id.et_es_estreno_album)

        val btnActualizarAlbum = findViewById<Button>(R.id.btn_actualizar_album)

        if (docRef != null) {
            docRef.get().addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.exists()) {
                    // Access the DocumentSnapshot data here.
                    val titulo = documentSnapshot.getString("titulo")
                    val duracionAux = documentSnapshot.getDouble("duracion")
                    val duracion = duracionAux.toString()
                    val fechaLanzamiento2 = documentSnapshot.getString("fechaLanzamiento")
                    val lanzamientoAux = documentSnapshot.getBoolean("esLanzamiento")
                    val lanzamiento = lanzamientoAux.toString()

                    tituloAlbum.setText(titulo)
                    duracionAlbum.setText(duracion)
                    fechaLanzamiento.setText(fechaLanzamiento2)
                    esLanzamiento.setText(lanzamiento)
                }
            }
        }

        btnActualizarAlbum.setOnClickListener {
            if (tituloAlbum.text.isNotEmpty()
                && duracionAlbum.text.isNotEmpty()
                && fechaLanzamiento.text.isNotEmpty()
                && esLanzamiento.text.isNotEmpty()){

                val tranformarLanzamientoActualizarCancion = esLanzamiento.text.toString()
                val resultadoLanzamiento = tranformarLanzamientoActualizarCancion.toBoolean()

                val transformarDuracionActualizarCancion = duracionAlbum.text.toString()
                val resultadoDuracion = transformarDuracionActualizarCancion.toDouble()

                val data = hashMapOf(
                    "titulo" to tituloAlbum.text.toString(),
                    "duracion" to resultadoDuracion,
                    "fechaLanzamiento" to fechaLanzamiento.text.toString(),
                    "esLanzamiento" to resultadoLanzamiento

                )

                if (albumID != null) {
                    database.collection("Album").document(albumID).update(data as Map<String, Any>).
                    addOnSuccessListener {
                        Toast.makeText(this, "¡Se ha actualizado el álbum!", Toast.LENGTH_SHORT).show()
                        irActividad(AlbumMain::class.java)
                    }.addOnFailureListener {
                        Toast.makeText(this, "Error al actualizar el álbum", Toast.LENGTH_SHORT).show()
                        irActividad(AlbumMain::class.java)
                    }
                }
            }
        }
    }

    private fun irActividad(
        activity: Class<*>
    ){
        val intent = Intent(this, activity)
        startActivity(intent)
    }
}
