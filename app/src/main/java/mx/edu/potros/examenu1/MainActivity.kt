package mx.edu.potros.examenu1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val campoC: TextView = findViewById(R.id.etC)
        val campoF: TextView = findViewById(R.id.etF)
        val btnGC: Button = findViewById(R.id.btnGC)
        val btnGF: Button = findViewById(R.id.btnGF)

        btnGC.setOnClickListener {
            var gradosF: Double = 0.0

            try {
                gradosF = campoF.text.toString().toDouble()
            } catch (e: java.lang.Exception) {
                println(e)
            }

            var gradosC = calcularGradosC(gradosF)
            val formattedNumber = "%.2f".format(gradosC)
            campoC.setText(formattedNumber)
        }

        btnGF.setOnClickListener {
            var gradosC: Double = 0.0

            try {
                gradosC = campoC.text.toString().toDouble()
            } catch (e: java.lang.Exception) {
                println(e)
            }

            var gradosF = calcularGradosF(gradosC)
            val formattedNumber = "%.2f".format(gradosF)
            campoF.setText(formattedNumber)
        }
    }

    fun calcularGradosF(gradosC: Double): Double {
        return gradosC * 1.8 + 32
    }

    fun calcularGradosC(gradosF: Double): Double {
        return (gradosF - 32) / 1.8
    }
}