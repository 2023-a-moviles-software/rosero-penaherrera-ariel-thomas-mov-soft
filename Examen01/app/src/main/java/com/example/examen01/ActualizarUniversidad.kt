package com.example.examen01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast

class ActualizarUniversidad : AppCompatActivity() {

    private var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        db = FirebaseFirestore.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_universidad)

        val bundle = intent.extras
        val idUniversidad = bundle?.getString("id")
        var docRef = idUniversidad?.let { db.collection("universidades").document(it)}

        val etFechaCreacionActualizado = findViewById<EditText>(R.id.etFechaCreacionActualizado)
        val etNombreUniversidadActualizado = findViewById<EditText>(R.id.etNombreUniversidadActualizado)
        val etEsPublicaActualizado = findViewById<EditText>(R.id.etEsPublicaActualizado)
        val etPromedioNotasActualizado = findViewById<EditText>(R.id.etPromedioNotasActualizado)

        if(docRef != null){
            docRef.get().addOnSuccessListener { documentSnapshot ->
                if(documentSnapshot.exists()){
                    //Access the documentSnapshot data here
                    val nombre = documentSnapshot.getString("nombre")
                    val auxEsPublica = documentSnapshot.getBoolean("esPublica")
                    val esPublica = auxEsPublica.toString()
                    val fechaCreacion = documentSnapshot.getString("fechaCreacion")
                    val auxPromedioNotas = documentSnapshot.getDouble("promedioNotas")
                    val promedioNotas = auxPromedioNotas.toString()

                    etFechaCreacionActualizado.setText(nombre)
                    etNombreUniversidadActualizado.setText(fechaCreacion)
                    etEsPublicaActualizado.setText(esPublica)
                    etPromedioNotasActualizado.setText(promedioNotas)
                }
            }
        }

        btnActualizarUniversidad.setOnClickListener {
            if (etNombreUniversidadActualizado.text.isNotEmpty()
                && etFechaCreacionActualizado.text.isNotEmpty()
                && etEsPublicaActualizado.text.isNotEmpty()
                && etPromedioNotasActualizado.text.isNotEmpty()){

                val transformacionEsPublica = etEsPublicaActualizado.text.toString()
                val resultadoEsPublica = transformacionEsPublica.toBoolean()

                val transformacionPromedioNotasActualizado = etPromedioNotasActualizado.text.toString()
                val resultadoPromedioNotasActualizado = transformacionPromedioNotasActualizado.toDouble()

                val data = hashMapOf(
                    "nombre" to etNombreUniversidadActualizado.text.toString(),
                    "fechaCreacion" to etFechaCreacionActualizado.text.toString(),
                    "esPublica" to resultadoEsPublica,
                    "promedioNotas" to resultadoPromedioNotasActualizado
                )

                if(idUniversidad != null){
                    db.collection("universidades").document(idUniversidad)
                        .update(data as Map<String, Any>).addOnSuccessListener{
                            Toast.makeText(
                                this,
                                "Actualizacion de la universidad exitoso!!",
                                Toast.LENGTH_SHORT
                            ).show()
                            irActividad(MainUniversidad::class.java)
                        }.addOnFailureListener {
                            Toast.makeText(
                                this,
                                "Se produjo un error al actualizar la universidad",
                                Toast.LENGTH_SHORT
                            ).show()
                            irActividad(MainUniversidad::class.java)
                        }
                }
            }
        }
    }

    private fun irActividad(activity: Class<*>){
        val intent = Intent(this, activity)
        startActivity(intent)
    }
}