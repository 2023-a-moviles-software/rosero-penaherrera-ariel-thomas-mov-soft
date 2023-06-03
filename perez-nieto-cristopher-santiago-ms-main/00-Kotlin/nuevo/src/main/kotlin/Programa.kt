import java.util.*

fun main(){
    println("Seleccione una opción")
    println("1")
    println("2")
    println("3")
    println("4")

}

abstract class NumerosJava1{
    protected val numeroUno: Int;
    protected val numeroDos: Int;

    constructor(
        uno: Int,
        dos: Int
    ){//Bloque codigo constructor
        this.numeroUno = uno;
        this.numeroDos = dos;
        println("Inicializando");
    }

    /*init { // Bloque de código del constructor PRIMARIO
        this.numeroUno
        numeroUno
        this.numeroDos
        numeroDos
        println("Inicializado");
    }*/
}