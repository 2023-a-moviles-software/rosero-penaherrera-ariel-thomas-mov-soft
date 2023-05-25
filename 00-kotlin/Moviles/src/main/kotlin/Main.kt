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
    val sumaUno = Suma(1,1)
    val sumaDos = Suma(null, 1)
    val sumaTres = Suma(1,null)
    val sumaCuatro = Suma(null,null)
    sumaUno.sumar()
    sumaDos.sumar()
    sumaTres.sumar()
    sumaCuatro.sumar()
    println(Suma.pi)
    println(Suma.elevarAlCuadrado(2))
    println(Suma.historialSumas)
    
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

class Suma( //Constructor primario
    unoParametro: Int, // Parametro
    dosParametro: Int, // Parametro
): Numeros(unoParametro, dosParametro){ //Extendiendo y mandando los parametro (superconstructor)
    init{
        //Bloque codigo constructor primario
        this.numeroUno
        this.numeroDos
    }

    constructor( //Segundo constructor
        uno: Int?, //Parametros
        dos: Int //Parametros
    ):this(
        if(uno == null) 0 else uno,
        dos
    )

    constructor( //Tercer constructor
        uno: Int, //Parametros
        dos: Int? //Parametros
    ):this(
        uno,
        if(dos == null) 0 else dos
    )

    constructor( //Cuarto constructor
        uno: Int?,
        dos: Int?
    ):this(
        if(uno == null) 0 else uno,
        if(dos == null) 0 else dos
    )

    public fun sumar(): Int{
        val total = numeroUno + numeroDos
        agregarHistorial(total) //this.agregarHistorial(total)
        return total
    }

    companion object{ //Atributos y metodos "Compartidos" Singletons o static de esta clase
        //Todas las instancias de esta clase comparten estos atributos y metodos
        //dentro del companion Ojbect
        val pi = 3.14
        fun elevarAlCuadrado(num: Int): Int{
            return num * num
        }
        val historialSumas = ArrayList<Int>()

        fun agregarHistorial(valorNuevaSuma: Int){
            historialSumas.add(valorNuevaSuma)
        }
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

