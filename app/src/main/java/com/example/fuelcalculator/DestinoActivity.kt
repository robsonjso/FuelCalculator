package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val KEY_DEST = "DestinoActivity.KEY"

class DestinoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destino)

        val edtdestino = findViewById<TextInputEditText>(R.id.edtDestin)
        val buttonResult = findViewById<Button>(R.id.btnResult)

        val price = intent.getFloatExtra("PriceActivity.KEY", 0f)
        val consumo = intent.getFloatExtra("ConsumoActivity.KEY", 0f)

        buttonResult.setOnClickListener {
            if (edtdestino.text.toString() == "") {
                //mostrar mensagem para usuario
                Snackbar
                    .make(
                        it,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    )
                    .show()
            } else {
                val destino = edtdestino.text.toString().toFloatOrNull() ?: 0.0

                val intentResultado = Intent(this, ResultadoActivity::class.java)
                intentResultado.putExtra(KEY_DEST, destino)
                intentResultado.putExtra("PriceActivity.KEY", price)
                intentResultado.putExtra("ConsumoActivity.KEY", consumo)
                startActivity(intentResultado)
            }
        }
    }
}