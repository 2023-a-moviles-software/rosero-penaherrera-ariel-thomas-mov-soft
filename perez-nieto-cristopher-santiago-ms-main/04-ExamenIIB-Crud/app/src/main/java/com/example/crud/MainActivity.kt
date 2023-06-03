package com.example.crud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAlbum = findViewById<Button>(R.id.btnRestaurant)
        btnAlbum.setOnClickListener{
            irActividad(AlbumMain::class.java)
        }

        val btnCancion = findViewById<Button>(R.id.btnDish)
        btnCancion.setOnClickListener{
            irActividad(CancionMain::class.java)
        }
    }

    private fun irActividad(
        activity: Class<*>
    ){
        val intent = Intent(this, activity)
        startActivity(intent)
    }
}