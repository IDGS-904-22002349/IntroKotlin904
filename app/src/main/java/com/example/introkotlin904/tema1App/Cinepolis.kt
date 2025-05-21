package com.example.introkotlin904.tema1App

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.R

class Cinepolis : AppCompatActivity() {
    private lateinit var etNombre: EditText
    private lateinit var etCompradores: EditText
    private lateinit var etBoletos: EditText
    private lateinit var rbCinecoSi: RadioButton
    private lateinit var rbCinecoNo: RadioButton
    private lateinit var tvResultado: TextView
    private val precioBoleta = 12000.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cinepolis)
        etNombre = findViewById(R.id.inputNombre)
        etCompradores = findViewById(R.id.inputCompradores)
        etBoletos = findViewById(R.id.inputBoletos)
        rbCinecoSi = findViewById(R.id.radioSi)
        rbCinecoNo = findViewById(R.id.radioNo)
        tvResultado = findViewById(R.id.textTotal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun calcularTotal(view: View) {
        val nombre = etNombre.text.toString().trim()
        val compradores = etCompradores.text.toString().toIntOrNull()
        val cantidadBoletos = etBoletos.text.toString().toIntOrNull()

        if (nombre.isEmpty() || compradores == null || cantidadBoletos == null) {
            Toast.makeText(this, "Por favor completa todos los campos correctamente.", Toast.LENGTH_SHORT).show()
            tvResultado.text = ""
            return
        }

        val maxPermitido = compradores * 7
        if (cantidadBoletos > maxPermitido) {
            Toast.makeText(this, "Máximo permitido: $maxPermitido boletas (7 por persona)", Toast.LENGTH_LONG).show()
            tvResultado.text = ""
            return
        }

        var total = cantidadBoletos * precioBoleta

        var descuento = 0.0
        if (cantidadBoletos > 5) {
            descuento = total * 0.15
        } else if (cantidadBoletos in 3..5) {
            descuento = total * 0.10
        }

        total -= descuento

        if (rbCinecoSi.isChecked) {
            val descuentoCineco = total * 0.10
            total -= descuentoCineco
        }

        tvResultado.text = "Total a pagar para $nombre: $%.2f".format(total)
    }
}