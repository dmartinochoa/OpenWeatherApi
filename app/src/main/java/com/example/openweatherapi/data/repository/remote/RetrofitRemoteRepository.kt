package com.example.openweatherapi.data.repository.remote

import android.accounts.NetworkErrorException
import com.example.openweatherapi.data.model.Weather
import com.example.openweatherapi.data.network.WeatherApiFactory

class RetrofitRemoteRepository : RemoteRepository {

    private val weatherApi = WeatherApiFactory.get()

    override suspend fun getWeather(location: String, key: String, unit: String): Weather {

        val response = weatherApi.getWeather(location, key, unit)

        if (response == null) {
            throw NetworkErrorException("Error fetching weather for location $location")
        }

        return response

    }

}