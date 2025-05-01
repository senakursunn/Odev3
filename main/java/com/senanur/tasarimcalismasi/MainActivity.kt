package com.senanur.tasarimcalismasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var quantity = 1
    private val pricePerItem = 6.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme.TasarimCalismasi) // Dark/Light desteği için
        setContentView(R.layout.activity_main)

        val textQty = findViewById<TextView>(R.id.textQty)
        val btnDecrease = findViewById<Button>(R.id.btnDecrease)
        val btnIncrease = findViewById<Button>(R.id.btnIncrease)
        val btnAddToCart = findViewById<Button>(R.id.btnAddToCart)

        btnIncrease.setOnClickListener {
            quantity++
            textQty.text = quantity.toString()
            updateButtonText(btnAddToCart)
        }

        btnDecrease.setOnClickListener {
            if (quantity > 1) {
                quantity--
                textQty.text = quantity.toString()
                updateButtonText(btnAddToCart)
            }
        }

        updateButtonText(btnAddToCart)
    }

    private fun updateButtonText(button: Button) {
        val total = quantity * pricePerItem
        button.text = getString(R.string.add_to_cart) + " - $" + total
    }
}
