import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.time.LocalDate

class Album {
    var id: Int = 0
    var fechaLanzamiento: LocalDate? = null
    var nombre: String = ""
    var duracionTotal: Float = 0f
    var esDebut: Boolean = true
    var listaCanciones = mutableListOf<Cancion>()

    constructor() {
    }

    constructor(id: Int, fechaLanzamiento: LocalDate, nombre: String, duracionTotal: Float, esDebut: Boolean
        , listaCanciones: MutableList<Cancion>)
    {
        this.id = id
        this.fechaLanzamiento = fechaLanzamiento
        this.nombre = nombre
        this.duracionTotal = duracionTotal
        this.esDebut = esDebut
        this.listaCanciones = listaCanciones
    }


    fun obtenerAtributos(): String {
        var idsCanciones: String = ""
        listaCanciones.forEach{
            idsCanciones += ","+it.id.toString()
        }
        return "$id,$fechaLanzamiento,$nombre,$duracionTotal,$esDebut$idsCanciones"
    }
    override fun toString(): String {
        var canciones: String = ""
        listaCanciones.forEach {
            canciones += it.nombre + "\n"
        }
        return "\nID: $id, Album: $nombre, Duracion: $duracionTotal min, Fecha: $fechaLanzamiento, " +
                "Debuta: $esDebut\n"+"Canciones:\n $canciones"
    }


}