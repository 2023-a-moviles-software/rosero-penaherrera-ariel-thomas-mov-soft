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

    //Arreglos

    //Tipos de Arreglos

    //Arreglo Estáticos
    val arregloEstatico: Array<Int> = aarayOf<Int>(1,2,3)
    println(arregloEstatico)

    //Arreglo Dinámico
    val arregloDinamico: ArrayList<Int> = arrayListOf<Int>(1,2,3,4,5,6,7,8,9,10)


    //Operadores -> Sirven para los arreglos estáticos y dinámicos

    //For Each -> Unir
    // Iterar un arreglo

    val respuestaForEach: Unit = arregloDinamico
        .forEach{
            valorActual: Int ->
            println("Valor actual: ${valorActual}")
        }
    arregloDinamico.forEach{ println(it) } //it (en ingles eso) significa el elemento iterado

    arregloEstatico
        .forEachIndexed {indice: Int, valorActual: Int ->
            println("Valor ${valorActual} Indice: ${indice}")
        }
    println(respuestaForEach)

    //MAP -> Muta el arreglo (camvia el arreglo)
    // 1) Enviemos el nuevo valor de la iteracion
    // 2) Nos devuelve un nuevo arreglo con los valores modificados

    val respuestaMap: List<Double> = arregloDinamico
        .map { valorActual: Int ->
            return@map valorActual.toDouble() + 100.00
        }

    println(respuestaMap)
    val respuestaMapDos = arregloDinamico.map { it + 15 }

    //Filter -> Filtrar el arreglo
    // 1) Devolver una expresion ( True o False )
    // 2) Nuevo arreglo filtrado
    val respuestaFilter: List<Int> = arregloDinamico
        .filter { valorActual: Int ->
            val mayoresACinco: Boolean = valorActual > 5 //Expresion condicion
            retuirn@filter mayoresACinco
        }
    val respuestaFilterDos = arregloDinamico.filter { it <= 5}
    println(respuestaFilter)
    println(respuestaFilterDos)

    //OR AND
    // OR -> ANY (Alguno cumple?)
    // AND -> ALL (Todos Cumplen?)

    val respuestaAny: Boolean = arregloDinamico
        .any { valorActual: Int ->
            return@any (valorActual > 5)
        }
    println(respuestaAny) // True

    val respuestaAll: Boolean = arregloDinamico
        .all { valorActual: Int ->
            return@all (valorActual > 5)
        }
    println(respuestaAll) //False

    //REDUCE -> Valor acumulado
    // Valor acumulado = 0 (Siempre 0 en lenguaje Kotlin)
    // [1,2,3,4,5] -> Sumeme todos los valores del arreglo
    // valorIteracion1 = valorEmpieza + 1 = 0 + 1 = 1 -> Iteracion 1
    // valorIteracion2 = valorEmpieza1 + 2 = 1 + 2 = 3 -> Iteracion 2
    // valorIteracion3 = valorEmpieza2 + 3 = 3 + 3 = 6 -> Iteracion 3
    // valorIteracion4 = valorEmpieza3 + 4 = 6 + 4 = 10 -> Iteracion 4
    // valorIteracion5 = valorEmpieza4 + 5 = 10 + 5 = 15 -> Iteracion 5

    val respuestaReduce: Int = arregloDinamico
        .reduce{ //Acumulado = 0 -> SIEMPRE EMPIEZA EN 0
            acumulado: Int, valorActual: Int ->
            return@reduce (acumulado + valorActual) // -> Logica negocio
        }
    println(respuestaReduce) // 78
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

