package com.example.cocinaya_apk

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleRecetaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalle_receta_activity)

        val nombreReceta = intent.getStringExtra("nombre_receta") ?: ""
        val ingredientes = intent.getStringExtra("ingredientes") ?: ""
        val preparacion = intent.getStringExtra("preparacion") ?: ""

        findViewById<TextView>(R.id.tvNombreReceta).text = nombreReceta
        findViewById<TextView>(R.id.tvIngredientes).text = ingredientes
        findViewById<TextView>(R.id.tvPreparacion).text = preparacion

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detalle de Receta"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}