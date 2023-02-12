package mx.itson.edu.examenu1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Varables del fronend
        //Edit text´s
        val etCel: EditText = findViewById(R.id.etC)
        val etFah: EditText = findViewById(R.id.etF)
        val etKel: EditText = findViewById(R.id.etK)

        //Estado inicial de los edittexr
        etCel.isEnabled = false
        etFah.isEnabled = false
        etKel.isEnabled = false

        //Buttons
        val toCel: Button = findViewById(R.id.btnGC)
        val toFah: Button = findViewById(R.id.btnGF)
        val toKel: Button = findViewById(R.id.btnGK)

        //Listeners
        toCel.setOnClickListener {
            etCel.isEnabled = true
            etFah.isEnabled = false
            etKel.isEnabled = false

            etCel.setText("")
            etFah.setText("")
            etKel.setText("")
        }
        toFah.setOnClickListener {
            etCel.isEnabled = false
            etFah.isEnabled = true
            etKel.isEnabled = false

            etCel.setText("")
            etFah.setText("")
            etKel.setText("")
        }
        toKel.setOnClickListener {
            etCel.isEnabled = false
            etFah.isEnabled = false
            etKel.isEnabled = true

            etCel.setText("")
            etFah.setText("")
            etKel.setText("")
        }

        etCel.addTextChangedListener {
            if (etCel.isEnabled && !etCel.text.toString().isEmpty()) {
                var celsius = etCel.text.toString().toDouble()

                etFah.setText(String.format("%.3f", celsiusToFahrenheit(celsius)))
                etKel.setText(String.format("%.3f", celsiusToKelvin(celsius)))
            }
        }
        etFah.addTextChangedListener {
            if (etFah.isEnabled && !etFah.text.toString().isEmpty()) {
                var fahrenheit = etFah.text.toString().toDouble()

                etCel.setText(String.format("%.3f", fahrenheitToCelsius(fahrenheit)))
                etKel.setText(String.format("%.3f", fahrenheitToKelvin(fahrenheit)))
            }
        }
        etKel.addTextChangedListener {
            if (etKel.isEnabled && !etKel.text.toString().isEmpty()) {
                var kelvin = etKel.text.toString().toDouble()

                etCel.setText(String.format("%.3f", kelvinToCelsius(kelvin)))
                etFah.setText(String.format("%.3f", kelvinToFahrenheit(kelvin)))
            }
        }
    }

    //Conversions
    fun celsiusToFahrenheit(cel: Double): Double {

        return (cel * (9.0/5.0)) + 32
    }

    fun celsiusToKelvin(cel: Double): Double {
        return cel + 273.15
    }

    fun fahrenheitToCelsius(fah: Double): Double {

        return (fah - 32) * (5.0/9.0)
    }

    fun fahrenheitToKelvin(fah: Double): Double {
        return fahrenheitToCelsius(fah) + 273.15
    }

    fun kelvinToCelsius(kel: Double): Double {
        return kel - 273.15
    }

    fun kelvinToFahrenheit(kel: Double): Double {
        return celsiusToFahrenheit(kelvinToCelsius(kel))
    }

}