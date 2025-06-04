package com.example.introkotlin904.diccionarioApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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
import java.io.FileNotFoundException

class ActivityBuscar : AppCompatActivity() {
    private lateinit var tvTituloBuscar: TextView
    private lateinit var rgLenguaje: RadioGroup
    private lateinit var rbEspanol: RadioButton
    private lateinit var rbIngles: RadioButton
    private lateinit var tvPalabraLabel: TextView
    private lateinit var etBuscarPalabra: EditText
    private lateinit var btnBuscarPalabra: Button
    private lateinit var tvTituloPalabraEncontrada: TextView
    private lateinit var tvPalabraEncontrada: TextView
    private lateinit var btnRegresarMenu: Button
    private val DICTIONARY_FILE_NAME = "dictionary.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buscar)
        tvTituloBuscar = findViewById(R.id.tvbuscar)
        rgLenguaje = findViewById(R.id.lenguajeRadioGroup)
        rbEspanol = findViewById(R.id.espanolRadioButton)
        rbIngles = findViewById(R.id.inglesRadioButton)
        tvPalabraLabel = findViewById(R.id.tvpalabra)
        etBuscarPalabra = findViewById(R.id.edtbuscarpalabra)
        btnBuscarPalabra = findViewById(R.id.btnbuscarpalabra)
        tvTituloPalabraEncontrada = findViewById(R.id.tvtitulopalabraencontrada)
        tvPalabraEncontrada = findViewById(R.id.tvpalabraencontrada)
        btnRegresarMenu = findViewById(R.id.backToMenuButton)

        tvTituloPalabraEncontrada.visibility = TextView.GONE
        tvPalabraEncontrada.visibility = TextView.GONE

        btnBuscarPalabra.setOnClickListener {
            buscarPalabra()
        }


        btnRegresarMenu.setOnClickListener {
            val intent = Intent(this, MainActivityDiccionario::class.java)
            startActivity(intent)
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun buscarPalabra() {
        val palabraABuscar = etBuscarPalabra.text.toString().trim()
        if (palabraABuscar.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa la palabra a buscar.", Toast.LENGTH_SHORT).show()
            tvTituloPalabraEncontrada.visibility = TextView.GONE
            tvPalabraEncontrada.visibility = TextView.GONE
            return
        }

        val buscarEnEspanol = rbEspanol.isChecked

        var traduccionEncontrada: String? = null

        try {
            openFileInput(DICTIONARY_FILE_NAME).bufferedReader().useLines { lineas ->
                for (linea in lineas) {
                    val partes = linea.split(":")
                    if (partes.size == 2) {
                        val espanol = partes[0].trim()
                        val ingles = partes[1].trim()

                        if (buscarEnEspanol && espanol.equals(palabraABuscar, ignoreCase = true)) {
                            traduccionEncontrada = ingles
                            break
                        } else if (!buscarEnEspanol && ingles.equals(palabraABuscar, ignoreCase = true)) {
                            traduccionEncontrada = espanol
                            break
                        }
                    }
                }
            }
        } catch (e: FileNotFoundException) {
            Toast.makeText(this, "No hay palabras guardadas aún.", Toast.LENGTH_SHORT).show()
            traduccionEncontrada = null
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Error al leer el diccionario: ${e.message}", Toast.LENGTH_LONG).show()
            traduccionEncontrada = null
        }


        if (traduccionEncontrada != null) {
            tvTituloPalabraEncontrada.text = "Palabra encontrada:"
            tvPalabraEncontrada.text = traduccionEncontrada
            tvTituloPalabraEncontrada.visibility = TextView.VISIBLE
            tvPalabraEncontrada.visibility = TextView.VISIBLE
        } else {
            tvTituloPalabraEncontrada.text = "Palabra no encontrada."
            tvPalabraEncontrada.text = ""
            tvTituloPalabraEncontrada.visibility = TextView.VISIBLE
            tvPalabraEncontrada.visibility = TextView.GONE
            Toast.makeText(this, "La palabra '$palabraABuscar' no se encontró.", Toast.LENGTH_SHORT).show()
        }
    }
}