package com.example.cocinaya_apk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val tvRegistroActivity = findViewById<TextView>(R.id.tvRegistro)
        tvRegistroActivity.setOnClickListener {
            val intent = Intent(this, RegistroActivity:: class.java)
            startActivity(intent)
        }

        val btnLogin = findViewById<Button>(R.id.btnInicio) // tu botón de login
        btnLogin.setOnClickListener {

            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }


        setContentView(R.layout.login_activity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
}