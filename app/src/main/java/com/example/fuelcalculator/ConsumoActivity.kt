package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val KEY_CONS = "ConsumoActivity.KEY"

class ConsumoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consumo)
        val price = intent.getFloatExtra("PriceActivity.KEY", 0f)

        val edtconsumo = findViewById<TextInputEditText>(R.id.edtConsumo)
        val buttonConsumo = findViewById<Button>(R.id.btnConsumo)

        buttonConsumo.setOnClickListener {
            if (edtconsumo.text.toString() == "") {
                //mostrar mensagem para usuario
                Snackbar
                    .make(
                        it,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    )
                    .show()
            } else {
                val consumo = edtconsumo.text.toString().toFloatOrNull() ?: 0.0
                val intent = Intent(this, DestinoActivity::class.java)


                intent.putExtra(KEY_CONS, consumo)
                intent.putExtra("PriceActivity.KEY", price)


                startActivity(intent)

            }
        }
    }
}