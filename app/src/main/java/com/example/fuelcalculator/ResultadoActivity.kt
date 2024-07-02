package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



const val KEY_Result = "ResultActivity.KEY"

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        // mostradores individuais
        val ResultPrice = findViewById<TextView>(R.id.ResultPrice)
        val ResultConsumo = findViewById<TextView>(R.id.ResultConsumo)
        val ResultDistancia = findViewById<TextView>(R.id.ResultDistancia)
        val textResultado = findViewById<TextView>(R.id.CalcResult)
        val buttonResult = findViewById<Button>(R.id.btnNovoCalc)

        val price = intent.getFloatExtra("PriceActivity.KEY", 0f);
        val consumo = intent.getFloatExtra("ConsumoActivity.KEY", 0f);
        val destino = intent.getFloatExtra("DestinoActivity.KEY", 0f);

        ResultPrice.text = price.toString()
        ResultConsumo.text = consumo.toString()
        ResultDistancia.text = destino.toString()

        val calcTotal = if (consumo != 0f) {
            (destino / consumo) * price

        } else {
            0f
        }
        textResultado.text = "R$ %.2f".format(calcTotal)

        buttonResult.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}


