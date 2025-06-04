package com.example.introkotlin904

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.tema1App.Cinepolis
import com.example.introkotlin904.tema1App.Ejemplo1Activity
import com.example.introkotlin904.tema2App.Ejemplo3Activity
import com.example.introkotlin904.Tema3.Ejemplo4Activity
import com.example.introkotlin904.Tema4.Ejemplo5Activity
import com.example.introkotlin904.calculadoraResistencia.ActivityCalculadoraResistencia
import com.example.introkotlin904.diccionarioApp.MainActivityDiccionario

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        val btnEjemplo1 = findViewById<Button>(R.id.btn1)
        val btnCinepolis = findViewById<Button>(R.id.btn2)
        val btnEjemplo2 = findViewById<Button>(R.id.btn3)
        val btnEjemplo3 = findViewById<Button>(R.id.btn4)
        val btnEjemplo4 = findViewById<Button>(R.id.btn5)
        val btnEjemplo5 = findViewById<Button>(R.id.btn6)
        val btnEjemplo6 = findViewById<Button>(R.id.btn7)
        btnEjemplo1.setOnClickListener {
           navigateToEjemplo1()
        }
        btnCinepolis.setOnClickListener {
            navigateToCinepolis()
        }
        btnEjemplo2.setOnClickListener {
            navigateToEjemplo2()
        }
        btnEjemplo3.setOnClickListener {
            navigateToEjemplo3()
        }
        btnEjemplo4.setOnClickListener {
            navigateToEjemplo4()
        }
        btnEjemplo5.setOnClickListener {
            navigateToEjemplo5()
        }
        btnEjemplo6.setOnClickListener {
            navigateToEjemplo6()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun navigateToEjemplo1(){
        val intent = Intent(this, Ejemplo1Activity::class.java)
        startActivity(intent)
    }

    private fun navigateToCinepolis(){
        val intent = Intent(this, Cinepolis::class.java)
        startActivity(intent)
    }

    private fun navigateToEjemplo2(){
        val intent = Intent(this, Ejemplo3Activity::class.java)
        startActivity(intent)
    }
    private fun navigateToEjemplo3(){
        val intent = Intent(this, Ejemplo4Activity::class.java)
        startActivity(intent)
    }
    private fun navigateToEjemplo4(){
        val intent = Intent(this, Ejemplo5Activity::class.java)
        startActivity(intent)
    }
    private fun navigateToEjemplo5(){
        val intent = Intent(this, MainActivityDiccionario::class.java)
        startActivity(intent)
    }
    private fun navigateToEjemplo6(){
        val intent = Intent(this, ActivityCalculadoraResistencia::class.java)
        startActivity(intent)
    }

}