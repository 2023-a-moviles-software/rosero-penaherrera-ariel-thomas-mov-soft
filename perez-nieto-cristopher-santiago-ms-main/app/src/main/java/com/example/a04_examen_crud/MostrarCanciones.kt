package com.example.a04_examen_crud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MostrarCanciones : AppCompatActivity() {
    private lateinit var cancionDao: CancionDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_canciones)

        cancionDao = CancionDatabase.getDatabase(this).cancionDao()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = CancionListAdapter(cancionDao.obtener_canciones())

    }
}