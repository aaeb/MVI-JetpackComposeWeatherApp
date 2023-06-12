package com.aaeb.weatherapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aaeb.weatherapp.domain.location.LocationTracker
import com.aaeb.weatherapp.domain.repository.WeatherRepository
import com.aaeb.weatherapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val locationTracker: LocationTracker
) : ViewModel() {

     var state by mutableStateOf(WeatherState())
        private set

    fun loadWeatherInfo() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )

            locationTracker.getCurrentLocation()?.let { location ->
                state = when (val result =
                    weatherRepository.getWeatherData(location.latitude, location.longitude)) {
                    is Resource.Success -> {
                        state.copy(isLoading = false, error = null, weatherInfo = result.data)
                    }

                    is Resource.Error -> {
                        state.copy(
                            error = result.message,
                            isLoading = false,
                            weatherInfo = null
                        )
                    }
                }
            } ?: kotlin.run {
                state = state.copy(
                    isLoading = false,
                    error = "Couldn't retrieve location. Make sure to grand permission and enable GPS"
                )
            }
        }
    }
}