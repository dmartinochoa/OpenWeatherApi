package com.example.openweatherapi.data.repository.remote

import android.accounts.NetworkErrorException
import com.example.openweatherapi.data.model.Weather
import com.example.openweatherapi.data.network.WeatherApiFactory

class RetrofitRemoteRepository : RemoteRepository {

    private val weatherApi = WeatherApiFactory.get()
    override suspend fun getWeather(location: String, key: String, unit: String): Weather {
        try {
            return weatherApi.getWeather(location, key, unit)
        } catch (e: Exception) {
            throw NetworkErrorException("Error fetching weather")
        }
    }
}