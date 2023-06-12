package com.aaeb.weatherapp.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.aaeb.weatherapp.data.mappers.toWeatherInfo
import com.aaeb.weatherapp.data.remote.WeatherApi
import com.aaeb.weatherapp.domain.repository.WeatherRepository
import com.aaeb.weatherapp.domain.util.Resource
import com.aaeb.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepoImpl @Inject constructor(private val weatherApi: WeatherApi) : WeatherRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = weatherApi.getWeatherData(lat, long).toWeatherInfo()
            )
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }
}