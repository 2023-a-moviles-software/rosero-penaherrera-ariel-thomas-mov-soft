package com.example.examen01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
//import com.google.firebase.FirebaseApp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //FirebaseApp.initializeApp(this);

        val btnUniversidades = findViewById<Button>(R.id.btnUniversidad)
        btnUniversidades.setOnClickListener {
            irActividad(MainUniversidad::class.java)
        }

        val btnFacultades = findViewById<Button>(R.id.btnFactuldad)
        btnFacultades.setOnClickListener {
            irActividad(MainFacultad::class.java)
        }
    }

    private fun irActividad(activity: Class<*>){
        val intent = Intent(this, activity)
        startActivity(intent)
    }

}