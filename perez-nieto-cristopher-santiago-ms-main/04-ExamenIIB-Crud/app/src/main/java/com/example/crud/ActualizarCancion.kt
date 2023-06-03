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

class ActualizarCancion : AppCompatActivity() {
    private var database = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        database = FirebaseFirestore.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_cancion)

        val bundle = intent.extras
        val cancionID = bundle?.getString("id")

        var docRef = cancionID?.let { database.collection("Cancion").document(it) }

        val nombreCancion = findViewById<EditText>(R.id.et_nombre_cancion)
        val fechaEstreno = findViewById<EditText>(R.id.et_fecha_estreno_cancion )
        val artista = findViewById<EditText>(R.id.et_artista_cancion )
        val esEstreno = findViewById<EditText>(R.id.et_es_estreno_cancion)

        val btnActualizarCancion = findViewById<Button>(R.id.btn_actualizar_cancion_2)

        if (docRef != null) {
            docRef.get().addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.exists()) {
                    // Access the DocumentSnapshot data here.
                    val nombre = documentSnapshot.getString("nombre")
                    val artistaCancion = documentSnapshot.getString("artista")
                    val fechaDeEstreno = documentSnapshot.getString("fechaEstreno")
                    val estrenoAux = documentSnapshot.getBoolean("esEstreno")
                    val estreno = estrenoAux.toString()


                    nombreCancion.setText(nombre)
                    artista.setText(artistaCancion)
                    fechaEstreno.setText(fechaDeEstreno)
                    esEstreno.setText(estreno)
                }
            }
        }

        btnActualizarCancion.setOnClickListener {
            if (nombreCancion.text.isNotEmpty()
                && fechaEstreno.text.isNotEmpty()
                && artista.text.isNotEmpty()
                && esEstreno.text.isNotEmpty()){

                val transformarEstrenoCancionActualizar = esEstreno.text.toString()
                val resultadoEstreno = transformarEstrenoCancionActualizar.toBoolean()

                val data = hashMapOf(
                    "nombre" to nombreCancion.text.toString(),
                    "artista" to artista.text.toString(),
                    "fechaEstreno" to fechaEstreno.text.toString(),
                    "esEstreno" to resultadoEstreno
                )

                if (cancionID != null) {
                    database.collection("Cancion").document(cancionID).update(data as Map<String, Any>).
                    addOnSuccessListener {
                        Toast.makeText(this, "¡Se ha actualizado la canción!", Toast.LENGTH_SHORT).show()
                        goActivity(CancionMain::class.java)
                    }.addOnFailureListener {
                        Toast.makeText(this, "Error al actualizar la canción", Toast.LENGTH_SHORT).show()
                        goActivity(CancionMain::class.java)
                    }
                }
            }
        }
    }

    private fun goActivity(activity: Class<*>){
        val intent = Intent(this, activity)
        startActivity(intent)
    }
}