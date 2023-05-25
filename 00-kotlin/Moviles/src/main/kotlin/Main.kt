import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")

   // INMUTABLES (No se reasignan "=")
    val inmutable: String = "Adrian";
    //inmutable = "Vicente";

    //MUTABLES (Re asignar)
    var mutable: String = "Vicente";
    mutable = "Adrian";

    // val > var (preferir las variables inmutables)

    // Duck Typing
    var ejemploVariable = "Adrian Eguez"
    val edadEjemplo: Int = 12
    ejemploVariable.trim()

    //Variable primitiva
    val nombreProfesor: String = "Adrian Eguez"
    val sueldo: Double = 1.2
    val estadoCivil: Char = 'C'
    val mayorEdad: Boolean = true

    //Clases Java
    val fechaNacimiento: Date = Date()

    //Condicionales
    // SWITCH

    val estadoCivilWhen = "C"
    when (estadoCivilWhen){
        ("C") -> {
            println("Casado")
        }
        "S" -> {
            println("Soltero")
        }
        else -> {
            println("No sabemos")
        }
    }
    val esSoltero = (estadoCivilWhen == "S")
    val coqueteo = if (esSoltero) "Si" else "No"
    calcularSueldo(10.00)
    calcularSueldo(10.00, 12.00, 20.00)
    calcularSueldo(10.00,bonoEspecial = 20.00) //Named Parameters
    calcularSueldo(bonoEspecial = 20.00, sueldo = 10.00, tasa = 14.00)
}

abstract class NumerosJava{
    protected val numeroUno: Int
    private val numeroDos: Int

    constructor(
        uno: Int,
        dos: Int
    ){
        //Bloque de codigo del constructor
        this.numeroUno = uno
        this.numeroDos = dos
        println("Iniciando")
    }
}

abstract class Numeros( //Constructor Primario
    //Ejemplo:
    // uno: Int, (Parametro (sin modificador de acceso))
    //private var uno: Int, //Propiedad Publica clase numeros.uno
    //var uno: Int, //Propiedad de la calse (por defecto es Public)
    // public var uno: Int,
    protected val numeroUno: Int, //Propiedad de la calse protected numeros.numeroUno
    protected val numeroDos: Int, //Propiedad de la calse protected numeros.numeroDos
){
    // var cedula: String = "" (public es por defecto)
    // private valorCalculado: Int = 0 (private)

    init { //bloque constructor primario
        this.numeroUno; this.numeroDos; //this es opcional
        numeroUno; numeroDos; // sin el "this", es lo mismo
        println("Inicializando")
    }
}


//Void -> unit

fun imprimirNombre(nombre: String): Unit{
    println("Nombre: ${nombre}") //template string
}

fun calcularSueldo(
    sueldo: Double, //Requerido
    tasa: Double = 12.00, //Opcional (defecto)
    bonoEspecial: Double? = null, //Opcion null -> nullable
): Double{
    //Int -> Int? (nullable)
    // String -> String? (nullable)
    //Date -> Date? (nullable)
    if(bonoEspecial == null){
        return sueldo * (100/tasa)
    } else {
        return sueldo * (100/tasa) + bonoEspecial
    }
}

