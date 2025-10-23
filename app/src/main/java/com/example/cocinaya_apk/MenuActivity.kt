package com.example.cocinaya_apk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_activity)

        setupRecipeButtons()

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.nav_inicio -> {}
                R.id.nav_mis_recetas -> {}
                R.id.nav_add -> {}
                R.id.nav_favoritos -> {}
                R.id.nav_perfil -> {}
            }
            true
        }
    }

    private fun setupRecipeButtons() {
        findViewById<Button>(R.id.btnCeviche).setOnClickListener {
            abrirDetalle("Ceviche", "• 1 kg de pescado\n• Limones\n• Cebolla\n• Ají\n• Sal", "1. Cortar el pescado en cubos\n2. Agregar limón y sal\n3. Dejar reposar 10 minutos\n4. Agregar cebolla y ají")
        }

        findViewById<Button>(R.id.btnLomoSaltado).setOnClickListener {
            abrirDetalle("Lomo Saltado", "• 500g lomo de res\n• Papas\n• Cebolla\n• Tomate\n• Sillao\n• Vinagre", "1. Cortar la carne en tiras\n2. Freír las papas\n3. Saltear la carne\n4. Agregar verduras y condimentos")
        }

        findViewById<Button>(R.id.btnArrozLeche).setOnClickListener {
            abrirDetalle("Arroz con Leche", "• 1 taza de arroz\n• 4 tazas de leche\n• Azúcar\n• Canela\n• Clavo de olor", "1. Hervir el arroz\n2. Agregar leche y especias\n3. Cocinar a fuego lento\n4. Endulzar al gusto")
        }

        findViewById<Button>(R.id.btnCremaVolteada).setOnClickListener {
            abrirDetalle("Crema Volteada", "• 6 huevos\n• 1 taza de azúcar\n• 2 tazas de leche\n• Vainilla", "1. Hacer caramelo\n2. Batir huevos con azúcar\n3. Agregar leche y vainilla\n4. Hornear a baño maría")
        }

        findViewById<Button>(R.id.btnCausaLimena).setOnClickListener {
            abrirDetalle("Causa Limeña", "• Papa amarilla\n• Limón\n• Ají amarillo\n• Pollo\n• Mayonesa\n• Palta", "1. Sancochar y prensar papas\n2. Mezclar con limón y ají\n3. Armar capas con relleno\n4. Decorar con palta")
        }

        findViewById<Button>(R.id.btnArrozPollo).setOnClickListener {
            abrirDetalle("Arroz con Pollo", "• 2 tazas de arroz\n• 1 pollo\n• Culantro\n• Cerveza\n• Verduras\n• Condimentos", "1. Dorar el pollo\n2. Licuar culantro\n3. Agregar arroz y líquidos\n4. Cocinar hasta que seque")
        }
    }

    private fun abrirDetalle(nombre: String, ingredientes: String, preparacion: String) {
        val intent = Intent(this, DetalleRecetaActivity::class.java)
        intent.putExtra("nombre_receta", nombre)
        intent.putExtra("ingredientes", ingredientes)
        intent.putExtra("preparacion", preparacion)
        startActivity(intent)
    }
}