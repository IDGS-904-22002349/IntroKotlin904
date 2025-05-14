package com.example.introkotlin904.tema1App

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.R

class Ejemplo2Activity : AppCompatActivity() {
    private lateinit var et1_1: EditText
    private lateinit var et2_1: EditText
    private lateinit var tv1_1: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo2)
        et1_1 = findViewById(R.id.et1_1)
        et2_1 = findViewById(R.id.et2_1)
        tv1_1 = findViewById(R.id.tv1_1)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcularMultiplicacion(view: View) {
        if (et1_1.text.isNotEmpty() && et2_1.text.isNotEmpty()) {
            try {
                val numero1 = et1_1.text.toString().toInt()
                val numero2 = et2_1.text.toString().toInt()

                var resultado = 0
                val operacion = StringBuilder()

                var contador = 0
                do {
                    resultado += numero1
                    operacion.append(numero1)

                    contador++

                    if (contador < numero2) {
                        operacion.append("+")
                    }
                } while (contador < numero2)

                tv1_1.text = "Resultado: $numero1×$numero2 = $operacion = $resultado"

            } catch (e: Exception) {
                Toast.makeText(this, "Error en el cálculo", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Ingrese ambos números", Toast.LENGTH_SHORT).show()
        }
    }
}