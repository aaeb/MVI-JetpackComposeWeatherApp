package com.aaeb.weatherapp.domain.repository

import com.aaeb.weatherapp.domain.util.Resource
import com.aaeb.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}