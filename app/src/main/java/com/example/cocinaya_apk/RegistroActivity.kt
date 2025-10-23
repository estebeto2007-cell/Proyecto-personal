package com.example.cocinaya_apk

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.registro_activity)

        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        val btnVolver = findViewById<Button>(R.id.btnVolver)
        val etCorreo = findViewById<TextInputEditText>(R.id.tietCorreo)
        val etClave = findViewById<TextInputEditText>(R.id.tietClave)
        val etConfClave = findViewById<TextInputEditText>(R.id.tieConfContra)

        btnRegistrar.setOnClickListener {
            val correo = etCorreo.text.toString().trim()
            val clave = etClave.text.toString().trim()
            val confClave = etConfClave.text.toString().trim()

            Log.d("REGISTRO", "Intentando registrar correo: '$correo' con clave: '$clave'")

            if (correo.isEmpty() || clave.isEmpty() || confClave.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            } else if (clave != confClave) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            } else {
                val sharedPref = getSharedPreferences("usuarios", MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putString(correo, clave)
                val success = editor.commit() // Usar commit() en lugar de apply() para verificar

                Log.d("REGISTRO", "Usuario guardado exitosamente: $success")
                Log.d("REGISTRO", "Verificando: clave guardada = '${sharedPref.getString(correo, "NO_ENCONTRADO")}'")

                Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        btnVolver.setOnClickListener {
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}