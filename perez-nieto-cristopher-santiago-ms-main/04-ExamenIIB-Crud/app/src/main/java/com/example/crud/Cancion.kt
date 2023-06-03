package com.example.crud

data class Cancion(
    var id: String = "",
    var nombre: String = "",
    var artista: String = "",
    var fechaEstreno: String = "",
    var esEstreno: Boolean? = null
) {
}