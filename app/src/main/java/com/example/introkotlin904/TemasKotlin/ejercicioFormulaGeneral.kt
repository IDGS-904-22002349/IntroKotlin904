package com.example.introkotlin904.TemasKotlin
import kotlin.math.sqrt

fun main() {
    println("¡Bienvenido al solucionador de la fórmula cuadrática!")

    var a: Double? = null
    while (a == null) {
        print("Ingresa el valor de a (no puede ser cero): ")
        val inputA = readlnOrNull()
        try {
            val tempA = inputA?.toDouble()
            if (tempA == null) {
                println("Entrada inválida. Intenta de nuevo.")
            } else if (tempA == 0.0) {
                println("El valor de 'a' no puede ser cero. Intenta de nuevo.")
            } else {
                a = tempA
            }
        } catch (e: NumberFormatException) {
            println("Entrada inválida. Debes ingresar un número. Intenta de nuevo.")
        }
    }

    var b: Double? = null
    while (b == null) {
        print("Ingresa el valor de b: ")
        val inputB = readlnOrNull()
        try {
            b = inputB?.toDouble() ?: run {
                println("Entrada inválida. Intenta de nuevo.")
                null
            }
        } catch (e: NumberFormatException) {
            println("Entrada inválida. Debes ingresar un número. Intenta de nuevo.")
        }
    }

    var c: Double? = null
    while (c == null) {
        print("Ingresa el valor de c: ")
        val inputC = readlnOrNull()
        try {
            c = inputC?.toDouble() ?: run {
                println("Entrada inválida. Intenta de nuevo.")
                null // Importante devolver null para que el bucle continúe
            }
        } catch (e: NumberFormatException) {
            println("Entrada inválida. Debes ingresar un número. Intenta de nuevo.")
        }
    }

    val discriminante = b!! * b!! - 4 * a!! * c!!

    if (discriminante > 0) {
        val raiz1 = (-b!! + sqrt(discriminante)) / (2 * a!!)
        val raiz2 = (-b!! - sqrt(discriminante)) / (2 * a!!)
        println("Las raíces son reales y distintas:")
        println("x1 = $raiz1")
        println("x2 = $raiz2")
    } else if (discriminante == 0.0) {
        val raiz = -b!! / (2 * a!!)
        println("La raíz es real y repetida:")
        println("x = $raiz")
    } else {
        val parteReal = -b!! / (2 * a!!)
        val parteImaginaria = sqrt(-discriminante) / (2 * a!!)
        println("Las raíces son complejas conjugadas:")
        println("x1 = $parteReal + ${parteImaginaria}i")
        println("x2 = $parteReal - ${parteImaginaria}i")
    }
}