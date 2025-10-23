package com.example.cocinaya_apk

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_activity)

        val tvRegistroActivity = findViewById<TextView>(R.id.tvRegistro)
        val btnLogin = findViewById<Button>(R.id.btnInicio)
        val etCorreo = findViewById<TextInputEditText>(R.id.tietCorreo)
        val etClave = findViewById<TextInputEditText>(R.id.tietClave)

        tvRegistroActivity.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            val correo = etCorreo.text.toString().trim()
            val clave = etClave.text.toString().trim()

            Log.d("LOGIN", "Intentando login con correo: '$correo' y clave: '$clave'")

            if (correo.isEmpty() || clave.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val sharedPref = getSharedPreferences("usuarios", MODE_PRIVATE)
                val claveGuardada = sharedPref.getString(correo, null)

                Log.d("LOGIN", "Clave guardada para '$correo': '$claveGuardada'")

                if (claveGuardada != null && claveGuardada == clave) {
                    Log.d("LOGIN", "Login exitoso")
                    Toast.makeText(this, "Iniciando sesión...", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                } else {
                    Log.d("LOGIN", "Login fallido - usuario no existe o clave incorrecta")
                    Toast.makeText(this, "Usuario no registrado o contraseña incorrecta", Toast.LENGTH_SHORT).show()
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}