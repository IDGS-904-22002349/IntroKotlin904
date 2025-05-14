package com.example.introkotlin904.tema1App

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.R

class Ejemplo1Activity : AppCompatActivity() {
    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var rgOperaciones: RadioGroup
    private lateinit var rbSumar: RadioButton
    private lateinit var rbRestar: RadioButton
    private lateinit var rbMultiplicar: RadioButton
    private lateinit var rbDividir: RadioButton
    private lateinit var tv1: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo1)

        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        rgOperaciones = findViewById(R.id.rgOperaciones)
        rbSumar = findViewById(R.id.rbSumar)
        rbRestar = findViewById(R.id.rbRestar)
        rbMultiplicar = findViewById(R.id.rbMultiplicar)
        rbDividir = findViewById(R.id.rbDividir)
        tv1 = findViewById(R.id.tv1)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcular(view: View) {

        if (et1.text.isEmpty() || et2.text.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese ambos números", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val valor1 = et1.text.toString().toDouble()
            val valor2 = et2.text.toString().toDouble()
            var resultado = 0.0

            when {
                rbSumar.isChecked -> {
                    resultado = sumar(valor1, valor2)
                }
                rbRestar.isChecked -> {
                    resultado = restar(valor1, valor2)
                }
                rbMultiplicar.isChecked -> {
                    resultado = multiplicar(valor1, valor2)
                }
                rbDividir.isChecked -> {
                    if (valor2 == 0.0) {
                        Toast.makeText(this, "No se puede dividir por cero", Toast.LENGTH_SHORT).show()
                        return
                    }
                    resultado = dividir(valor1, valor2)
                }
            }

            if (resultado == resultado.toLong().toDouble()) {
                tv1.text = "Resultado: ${resultado.toLong()}"
            } else {
                tv1.text = "Resultado: ${String.format("%.2f", resultado)}"
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Error al realizar el cálculo", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sumar(a: Double, b: Double): Double {
        return a + b
    }

    private fun restar(a: Double, b: Double): Double {
        return a - b
    }

    private fun multiplicar(a: Double, b: Double): Double {
        return a * b
    }

    private fun dividir(a: Double, b: Double): Double {
        return a / b
    }
}