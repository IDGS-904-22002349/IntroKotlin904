package com.example.introkotlin904.diccionarioApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.R

class MainActivityDiccionario : AppCompatActivity() {
    private lateinit var btnCapturar: Button
    private lateinit var btnBuscar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_diccionario)
        btnCapturar = findViewById(R.id.btn_capturar)
        btnBuscar = findViewById(R.id.btn_buscar)
        btnCapturar.setOnClickListener {
            val intent = Intent(this, ActivityCapturar::class.java)
            startActivity(intent)
        }
        btnBuscar.setOnClickListener {
            val intent = Intent(this, ActivityBuscar::class.java)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}