package com.example.crud

data class Album (
    var id: String = "",
    var titulo: String = "",
    var duracion: Double = 0.0,
    var fechaLanzamiento: String = "",
    var esLanzamiento: Boolean? = null
        )