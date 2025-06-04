package com.example.introkotlin904.calculadoraResistencia

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.R

class ActivityCalculadoraResistencia : AppCompatActivity() {
    private lateinit var spinnerColorBanda1: Spinner
    private lateinit var spinnerColorBanda2: Spinner
    private lateinit var spinnerMultiplicador: Spinner
    private lateinit var grupoRadioTolerancia: RadioGroup
    private lateinit var radioOro: RadioButton
    private lateinit var radioPlata: RadioButton
    private lateinit var botonCalcular: Button
    private lateinit var valorBanda1: TextView
    private lateinit var valorBanda2: TextView
    private lateinit var valorMultiplicador: TextView
    private lateinit var valorOhm: TextView
    private lateinit var valorMaximo: TextView
    private lateinit var valorMinimo: TextView

    private val nombresColores = listOf(
        "Negro", "Marrón", "Rojo", "Naranja", "Amarillo",
        "Verde", "Azul", "Violeta", "Gris", "Blanco", "Oro", "Plata"
    )

    private val valoresColores = listOf(
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1
    )

    private val valoresMultiplicadores = listOf(
        1.0, 10.0, 100.0, 1000.0, 10000.0,
        100000.0, 1000000.0, 10000000.0, 100000000.0, 1000000000.0, 0.1, 0.01
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora_resistencia)

        spinnerColorBanda1 = findViewById(R.id.spinnerColor1)
        spinnerColorBanda2 = findViewById(R.id.spinnerColor2)
        spinnerMultiplicador = findViewById(R.id.spinnerMultiplier)
        grupoRadioTolerancia = findViewById(R.id.radioGroupTolerance)
        radioOro = findViewById(R.id.radioOro)
        radioPlata = findViewById(R.id.radioPlata)
        botonCalcular = findViewById(R.id.calculateButton)
        valorBanda1 = findViewById(R.id.valueColor1)
        valorBanda2 = findViewById(R.id.valueColor2)
        valorMultiplicador = findViewById(R.id.valueMultiplier)
        valorOhm = findViewById(R.id.valueOhm)
        valorMaximo = findViewById(R.id.valueMaximo)
        valorMinimo = findViewById(R.id.valueMinimo)

        configurarSpinners()

        botonCalcular.setOnClickListener {
            calcularResistencia()
        }

        spinnerColorBanda1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val coloresNumericosActuales = nombresColores.filterIndexed { index, _ -> valoresColores[index] != -1 }
                val indiceOriginal = nombresColores.indexOf(coloresNumericosActuales[position])
                valorBanda1.text = valoresColores[indiceOriginal].toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spinnerColorBanda2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val coloresNumericosActuales = nombresColores.filterIndexed { index, _ -> valoresColores[index] != -1 }
                val indiceOriginal = nombresColores.indexOf(coloresNumericosActuales[position])
                valorBanda2.text = valoresColores[indiceOriginal].toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spinnerMultiplicador.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val coloresMultiplicador = nombresColores.filterIndexed { index, _ -> valoresColores[index] != -1 }
                val indiceOriginal = nombresColores.indexOf(coloresMultiplicador[position])
                valorMultiplicador.text = valoresColores[indiceOriginal].toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        valorBanda1.text = valoresColores[0].toString()
        valorBanda2.text = valoresColores[0].toString()
        valorMultiplicador.text = valoresColores[0].toString()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun configurarSpinners() {
        val nombresColoresBandaNumerica = nombresColores.filterIndexed { index, _ -> valoresColores[index] != -1 }

        val adaptadorColor1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, nombresColoresBandaNumerica)
        adaptadorColor1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerColorBanda1.adapter = adaptadorColor1

        val adaptadorColor2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, nombresColoresBandaNumerica)
        adaptadorColor2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerColorBanda2.adapter = adaptadorColor2

        val adaptadorMultiplicador = ArrayAdapter(this, android.R.layout.simple_spinner_item, nombresColoresBandaNumerica)
        adaptadorMultiplicador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerMultiplicador.adapter = adaptadorMultiplicador
    }

    private fun calcularResistencia() {
        val indiceSeleccionadoBanda1 = spinnerColorBanda1.selectedItemPosition
        val indiceSeleccionadoBanda2 = spinnerColorBanda2.selectedItemPosition
        val indiceSeleccionadoMultiplicador = spinnerMultiplicador.selectedItemPosition

        val nombresColoresBandaNumerica = nombresColores.filterIndexed { index, _ -> valoresColores[index] != -1 }

        val indiceOriginalBanda1 = nombresColores.indexOf(nombresColoresBandaNumerica[indiceSeleccionadoBanda1])
        val indiceOriginalBanda2 = nombresColores.indexOf(nombresColoresBandaNumerica[indiceSeleccionadoBanda2])
        val indiceOriginalMultiplicador = nombresColores.indexOf(nombresColoresBandaNumerica[indiceSeleccionadoMultiplicador])

        val valorBanda1Numerico = valoresColores[indiceOriginalBanda1]
        val valorBanda2Numerico = valoresColores[indiceOriginalBanda2]
        val valorMultiplicadorNumerico = valoresMultiplicadores[indiceOriginalMultiplicador]

        val valorResistencia = (valorBanda1Numerico * 10 + valorBanda2Numerico).toDouble() * valorMultiplicadorNumerico

        val idToleranciaSeleccionada = grupoRadioTolerancia.checkedRadioButtonId
        val porcentajeTolerancia = when (idToleranciaSeleccionada) {
            R.id.radioOro -> 0.05
            R.id.radioPlata -> 0.10
            else -> 0.0
        }

        val resistenciaMaxima = valorResistencia * (1 + porcentajeTolerancia)
        val resistenciaMinima = valorResistencia * (1 - porcentajeTolerancia)

        valorOhm.text = String.format("valor ohm %.2f", valorResistencia)
        valorMaximo.text = String.format("valor maximo %.2f", resistenciaMaxima)
        valorMinimo.text = String.format("valor minimo %.2f", resistenciaMinima)
    }
}