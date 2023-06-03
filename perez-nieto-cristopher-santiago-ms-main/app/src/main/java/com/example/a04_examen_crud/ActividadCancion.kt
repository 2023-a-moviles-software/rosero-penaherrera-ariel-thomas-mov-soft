package com.example.a04_examen_crud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActividadCancion : AppCompatActivity() {
    private lateinit var cancionDao: CancionDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_cancion)

        // Inicializar el DAO de la base de datos
        cancionDao = CancionDatabase.getDatabase(this).cancionDao()

        // Agregar una canción
        val boton_agregar = findViewById<Button>(R.id.btn_anadir_cancion)
        boton_agregar.setOnClickListener {
                val book = Cancion().apply {
                title = "Yonaguni"
                author = "Bad Bunny"
                year = 2021
            }
            cancionDao.insert(book)
        }

        // Mostrar todas las canciones
        val boton_mostrar = findViewById<Button>(R.id.btn_mostrar_canciones)
        boton_mostrar.setOnClickListener {
            val canciones = cancionDao.obtener_canciones()
            // Mostrar las canciones en un ListView o RecyclerView
            val intent = Intent(this, MostrarCanciones::class.java)
            startActivity(intent)
        }

        // Actualizar una canción
        val boton_actualizar = findViewById<Button>(R.id.btn_actualizar_cancion)
        boton_actualizar.setOnClickListener {
            val cancion = cancionDao.obtener_cancion_por_id(1) // Obtener una canción por su ID
            cancion?.apply {
                title = "Nuevo título"
                author = "Nuevo autor"
                year = 2023
            }
            cancion?.let { cancionDao.update(it) } // Actualizar la canción en la base de datos
        }

        // Eliminar una canción
        val buttonDeleteBook = findViewById<Button>(R.id.button_delete_book)
        buttonDeleteBook.setOnClickListener {
            val cancion = cancionDao.obtener_cancion_por_id(1) // Obtener una canción por su ID
            cancion?.let { cancionDao.delete(it) } // Eliminar la canción de la base de datos
        }
    }
}