package com.example.openweatherapi.data.network

import com.example.openweatherapi.data.model.Weather
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/data/2.5/weather")
    suspend fun getWeather(
        @Query("q") location: String,
        @Query("APPID") appId: String,
        @Query("units") unti: String
    ): Weather
}

object WeatherApiFactory {
    fun get(): WeatherApi {
        val retrofit = Retrofit.Builder().baseUrl("https://api.openweathermap.org")
            .addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit.create(WeatherApi::class.java)
    }
}