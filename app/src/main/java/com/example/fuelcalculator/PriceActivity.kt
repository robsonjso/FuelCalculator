package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val KEY_PRICE = "PriceActivity.KEY"

class PriceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_price)

        val edtprice = findViewById<TextInputEditText>(R.id.edtPrice)
        val buttonPrice = findViewById<Button>(R.id.btnPrice)

        buttonPrice.setOnClickListener {
            if (edtprice.text.toString() == "" ) {
                //mostrar mensagem para usuario
                Snackbar
                    .make(
                        it,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    )
                    .show()
            } else {
                val price = edtprice.text.toString().toFloatOrNull() ?: 0.0
                val intent = Intent(this, ConsumoActivity::class.java)

                intent.putExtra(KEY_PRICE, price)
                startActivity(intent)
            }
        }
    }
}
