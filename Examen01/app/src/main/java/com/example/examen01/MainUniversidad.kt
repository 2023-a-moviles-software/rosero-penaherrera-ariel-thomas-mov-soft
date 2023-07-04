package com.example.examen01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainUniversidad : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var listaUniversidades: Array<Universidad>
    private var db = Firebase.firestore
    var idUniversidad = ""

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_universidad)

        recyclerView = findViewById(R.id.recyclerUniversidades)
        recyclerView.layoutManager = LinearLayoutManager(this)

        listaUniversidades = arrayListOf()

        db = FirebaseFirestore.getInstance()

        db.collection("universidades").get().addSuccessListener {
            if(!it.isEmpty){
                for(document in it.documents){
                    val itemUniversidad: Universidad? = document.toObject(Universidad::class.java)
                    if(itemUniversidad != null){
                        itemUniversidad.id = document.id
                        println(itemUniversidad.id)
                        listaUniversidades.add(itemUniversidad)
                    }
                }

                val adapter = UniversidadAdapter(listaUniversidades)
                recyclerView.adapter = adapter
                adapter.setOnItemClickListener(object : UniversidadAdapter.onItemClickListener{
                    override fun onClick(position: Int){
                        val idUniversidad = listaUniversidades[position].id
                        Toast.makeText(this@MainUniversidad, "Id: $idUniversidad", Toast.LENGTH_SHORT)
                            .show()
                        val btnEditarUniversidad = findViewById<Button>(R.id.btnEditarUniversidad)
                        btnEditarUniversidad.setOnClickListener{
                            enviarDatosOtraActividad(ActualizarUniversidad::class.java, idUniversidad)
                        }
                    }
                })
            }
        }

            .addOnFailureListener{
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            }

        val btnCrearUniversidad = findViewById<Button>(R.id.btnCrearUniversidad)
        btnCrearUniversidad.setOnClickListener{
            irActividad(CrearUniversidad::class.java)
        }
    }

    private fun irActividad(activity: Class<*>){
        val intent = Intent(this, activity)
        startActivity(intent)
    }

    private fun enviarDatosOtraActividad(activity: Class<*>, id: String){
        val intent = Intent(this, activity)
        intent.putExtra("id", id)
        startActivity(intent)
    }
}