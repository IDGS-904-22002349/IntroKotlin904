package com.example.introkotlin904.TemasKotlin

fun main() {
    var opcion: Int

    do {
        mostrarMenu()
        print("Seleccione una opción: ")
        opcion = try {
            readln().toInt()
        } catch (e: NumberFormatException) {
            println("Entrada no válida para la opción.")
            0
        }

        when (opcion) {
            1 -> realizarSuma()
            2 -> realizarResta()
            3 -> realizarMultiplicacion()
            4 -> realizarDivision()
            5 -> println("Saliendo del programa...")
            else -> println("Opción no válida. Por favor, seleccione un número del 1 al 5.")
        }
        println()

    } while (opcion != 5)
}

fun mostrarMenu() {
    println("--- Menú de Operaciones ---")
    println("1. Suma")
    println("2. Resta")
    println("3. Multiplicación")
    println("4. División")
    println("5. Salir")
    println("--------------------------")
}

fun realizarSuma() {
    print("Ingrese el primer número: ")
    val num1 = try {
        readln().toDouble()
    } catch (e: NumberFormatException) {
        println("Entrada no válida para el primer número.")
        0.0
    }
    print("Ingrese el segundo número: ")
    val num2 = try {
        readln().toDouble()
    } catch (e: NumberFormatException) {
        println("Entrada no válida para el segundo número.")
        0.0
    }
    val resultado = num1 + num2
    println("El resultado de la suma es: $resultado")
}

fun realizarResta() {
    print("Ingrese el primer número: ")
    val num1 = try {
        readln().toDouble()
    } catch (e: NumberFormatException) {
        println("Entrada no válida para el primer número.")
        0.0
    }
    print("Ingrese el segundo número: ")
    val num2 = try {
        readln().toDouble()
    } catch (e: NumberFormatException) {
        println("Entrada no válida para el segundo número.")
        0.0
    }
    val resultado = num1 - num2
    println("El resultado de la resta es: $resultado")
}

fun realizarMultiplicacion() {
    print("Ingrese el primer número: ")
    val num1 = try {
        readln().toDouble()
    } catch (e: NumberFormatException) {
        println("Entrada no válida para el primer número.")
        0.0
    }
    print("Ingrese el segundo número: ")
    val num2 = try {
        readln().toDouble()
    } catch (e: NumberFormatException) {
        println("Entrada no válida para el segundo número.")
        0.0
    }
    val resultado = num1 * num2
    println("El resultado de la multiplicación es: $resultado")
}

fun realizarDivision() {
    print("Ingrese el dividendo: ")
    val dividendo = try {
        readln().toDouble()
    } catch (e: NumberFormatException) {
        println("Entrada no válida para el dividendo.")
        0.0
    }
    print("Ingrese el divisor: ")
    val divisor = try {
        readln().toDouble()
    } catch (e: NumberFormatException) {
        println("Entrada no válida para el divisor.")
        0.0
    }

    if (divisor != 0.0) {
        val resultado = dividendo / divisor
        println("El resultado de la división es: $resultado")
    } else {
        println("Error: No se puede dividir entre cero.")
    }
}