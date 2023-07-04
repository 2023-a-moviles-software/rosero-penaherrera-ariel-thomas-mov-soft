package com.example.examen01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CrearUniversidad : AppCompatActivity() {

    private var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_universidad)

        val etFechaCreacion = findViewById<EditText>(R.id.etFechaCreacion)
        val etNombreUniversidad = findViewById<EditText>(R.id.etNombreUniversidad)
        val etEsPublica = findViewById<EditText>(R.id.etEsPublica)
        val etPromedioNotas = findViewById<EditText>(R.id.etPromedioNotas)

        val btnGuardarUniversidad = findViewById<Button>(R.id.btnGuardarUniversidad)
        btnGuardarUniversidad.setOnClickListener {
            if (etNombreUniversidad.text.isNotEmpty()
                && etFechaCreacion.text.isNotEmpty()
                && etEsPublica.text.isNotEmpty()
                && etPromedioNotas.text.isNotEmpty()){

                val transformacionEsPublica = etEsPublica.text.toString()
                val resultadoEsPublica = transformacionEsPublica.toBoolean()

                val transformacionPromedioNotas = etPromedioNotas.text.toString()
                val resultadoPromedioNotas = transformacionPromedioNotas.toDouble()

                val data = hashMapOf(
                    "nombre" to etNombreUniversidad.text.toString(),
                    "fechaCreacion" to etFechaCreacion.text.toString(),
                    "esPublica" to resultadoEsPublica,
                    "promedioNotas" to resultadoPromedioNotas
                )

                db.collection("universidades").add(data).addOnSuccessListener {
                    Toast.makeText(this, "Se creò la universidad con èxito", Toast.LENGTH_SHORT)
                        .show()
                    irActividad(MainUniversidad::class.java)
                }.addOnFailureListener {
                    Toast.makeText(
                        this,
                        "Se produjo un error al crear la universidad",
                        Toast.LENGTH_SHORT
                    ).show()
                    irActividad(MainUniversidad::class.java)
                }
            }
        }
    }

    private fun irActividad(activity: Class<*>){
        val intent = Intent(this, activity)
        startActivity(intent)
    }
}