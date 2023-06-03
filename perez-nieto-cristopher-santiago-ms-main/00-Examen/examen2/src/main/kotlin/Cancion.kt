import java.util.*
import java.time.LocalDate

class Cancion {
    var id: Int = 0
    var fechaEstreno: LocalDate? = null
    var nombre: String = ""
    var duracion: Float = 0f
    var esExplicita: Boolean = true
    constructor() {
    }

    constructor(id: Int, fechaEstreno: LocalDate, nombre: String, duracion: Float, esExplicita: Boolean) {
        this.id = id
        this.fechaEstreno = fechaEstreno
        this.nombre = nombre
        this.duracion = duracion
        this.esExplicita = esExplicita
    }
    override fun toString(): String {
        return "id: $id, Fecha: $fechaEstreno, Cancion: $nombre, Duracion: $duracion min, Explicita: $esExplicita"
    }

    fun obtenerAtributos(): String {
        return "$id,$fechaEstreno,$nombre,$duracion,$esExplicita"
    }
}