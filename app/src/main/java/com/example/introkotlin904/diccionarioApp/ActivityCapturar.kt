package com.example.introkotlin904.diccionarioApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.R
import java.io.IOException

class ActivityCapturar : AppCompatActivity() {
    private lateinit var etEspañol: EditText
    private lateinit var etIngles: EditText
    private lateinit var btnGuardar: Button
    private lateinit var btnMenu: Button
    private val DICTIONARY_FILE_NAME = "dictionary.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capturar)
        etEspañol = findViewById(R.id.edtespanol)
        etIngles = findViewById(R.id.edtingles)
        btnGuardar = findViewById(R.id.saveButton)
        btnMenu = findViewById(R.id.btnmenu)

        btnGuardar.setOnClickListener {
            guardarPalabras()
        }

        btnMenu.setOnClickListener {
            val intent = Intent(this, MainActivityDiccionario::class.java)
            startActivity(intent)
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun guardarPalabras() {
        val palabraEspanol = etEspañol.text.toString().trim()
        val palabraIngles = etIngles.text.toString().trim()

        if (palabraEspanol.isEmpty() || palabraIngles.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa ambas palabras.", Toast.LENGTH_SHORT).show()
            return
        }

        val wordPair = "$palabraEspanol:$palabraIngles\n"

        try {
            openFileOutput(DICTIONARY_FILE_NAME, MODE_APPEND).use {
                it.write(wordPair.toByteArray())
            }

            etEspañol.text.clear()
            etIngles.text.clear()

            Toast.makeText(this, "Palabra guardada correctamente.", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {

            e.printStackTrace()

            Toast.makeText(this, "Error al guardar la palabra: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

}