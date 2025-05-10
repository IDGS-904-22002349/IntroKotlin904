package com.example.introkotlin904.TemasKotlin

fun main() {
    var numero: Int

    do {
        do {
            print("Ingrese un número entero positivo para la serie de asteriscos (ingrese 0 para salir): ")
            val input = readln()

            try {
                numero = input.toInt()
            } catch (e: NumberFormatException) {
                numero = -1
                println("Entrada inválida. Por favor, ingrese un número entero positivo.")
            }

            if (numero > 0) {
                println("\nGenerando serie de asteriscos:")

                var contador = 1
                do {
                    var asteriscos = 1
                    do {
                        print("*")
                        asteriscos++
                    } while (asteriscos <= contador)
                    println()
                    contador++
                } while (contador <= numero)
            }
        } while (numero < 0)

    } while (numero != 0)

    println("Saliendo del programa.")
}