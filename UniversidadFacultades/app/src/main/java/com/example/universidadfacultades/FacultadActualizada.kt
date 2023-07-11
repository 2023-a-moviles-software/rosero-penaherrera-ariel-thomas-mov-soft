package com.example.universidadfacultades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FacultadActualizada : AppCompatActivity() {
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facultad_actualizada)
        this.setTitle("Actualizar Facultad")
        initEventFiltrar()
        iniEventActualizarFacultad()
    }
    fun initEventFiltrar(){
        val btnFirestore = findViewById<Button>(R.id.btn_buscarID)
        btnFirestore.setOnClickListener{
            val nombreUniversidad = findViewById<EditText>(R.id.tv_nombreUniversidad)//Para filtrar
            val idFacultadDB = findViewById<EditText>(R.id.tv_IDFacultad)// Para filtrar

            val nombreFacultad = findViewById<EditText>(R.id.tv_nombreFacultad)//campos editar
            val numCarreras = findViewById<EditText>(R.id.tv_numeroCarreras)
            val numEstudiantes = findViewById<EditText>(R.id.tv_numeroEstudiantes)
            val numeroDocentes = findViewById<EditText>(R.id.tv_numeroDocentes)

            db.collection(nombreUniversidad.text.toString()).document(idFacultadDB.text.toString()).get().addOnSuccessListener {
                nombreFacultad.setText(it.get("nombreFacultad") as String?)
                nombreUniversidad.setText(it.get("nombreUniversidad") as String?)
                numCarreras.setText(it.get("numeroCarreras")as String?)
                numEstudiantes.setText(it.get("numeroEstudiantes")as String?)
                numeroDocentes.setText(it.get("numeroDocentes")as String?)
            }
        }
    }
    fun iniEventActualizarFacultad(){
        val btnFirestore = findViewById<Button>(R.id.btn_editarFacultad)
        btnFirestore.setOnClickListener{
            val nombreUniversidad = findViewById<EditText>(R.id.tv_nombreUniversidad)//
            val idFacultadDB = findViewById<EditText>(R.id.tv_IDFacultad)// Para filtrar

            val nombreFacultad = findViewById<EditText>(R.id.tv_nombreFacultad)
            val numCarreras = findViewById<EditText>(R.id.tv_numeroCarreras)
            val numEstudiantes = findViewById<EditText>(R.id.tv_numeroEstudiantes)
            val numeroDocentes = findViewById<EditText>(R.id.tv_numeroDocentes)

            db.collection(nombreUniversidad.text.toString()).document(idFacultadDB.text.toString()).set(
                hashMapOf(
                    "nombreFacultad" to nombreFacultad.text.toString(),
                    "nombreUniversidad" to nombreUniversidad.text.toString(),
                    "numeroCarreras" to numCarreras.text.toString(),
                    "numeroEstudiantes" to numEstudiantes.text.toString(),
                    "numeroDocentes" to numeroDocentes.text.toString()
                )
            )
        }
    }
}