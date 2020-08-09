package com.example.openweatherapi.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.openweatherapi.R
import com.example.openweatherapi.data.model.Weather
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainPresenter.View {
    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.init()

    }

    @SuppressLint("SetTextI18n")
    override fun showWeather(weatherData: Weather) {
        locationTxt.text = weatherData.name
        minValue.text = weatherData.main?.tempMin.toString() + "°C"
        maxValue.text = weatherData.main?.tempMax.toString() + "°C"
        tempValue.text = weatherData.main?.temp.toString() + "°C"
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
