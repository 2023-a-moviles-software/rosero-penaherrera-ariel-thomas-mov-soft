package com.example.a04_examen_crud

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "canciones")
data class Cancion(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String? = null,
    var author: String? = null,
    var year: Int = 0
)