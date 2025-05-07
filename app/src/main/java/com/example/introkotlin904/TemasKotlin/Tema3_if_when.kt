package com.example.introkotlin904.TemasKotlin

fun main(){
    val d:Int
    val check=true

    if(check){
        d=1
    }else{
        d=2
    }

    println(d)

    val d2=if(check) 1 else 2
    println(d2)

    println("__________________________________________________________________")
    print("Ingrese el sueldo del empleado: ")
    val sueldo= readln().toDouble()
    if (sueldo>3000){
        println("Debe pagar impuestos")
    }
}