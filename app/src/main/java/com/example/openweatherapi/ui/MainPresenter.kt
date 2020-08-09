package com.example.openweatherapi.ui

import android.accounts.NetworkErrorException
import com.example.openweatherapi.data.model.Weather
import com.example.openweatherapi.data.repository.remote.RemoteRepository
import com.example.openweatherapi.data.repository.remote.RetrofitRemoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainPresenter(private val view: View) {
    private val remoteRepository: RemoteRepository = RetrofitRemoteRepository()
    fun init() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val weatherResponse =
                    withContext(Dispatchers.IO) {
                        remoteRepository.getWeather(
                            "Madrid,spain",
                            "b199e65df91ef3a207b63cac52af1e58",
                            "metric"
                        )
                    }
                view.showWeather(weatherResponse)
            } catch (e: NetworkErrorException) {
                view.showError(e.message!!)
            }

        }
    }

    fun onRefresh() {
        init()
    }

    interface View {
        fun showWeather(weatherData: Weather)
        fun showError(message: String)
    }
}