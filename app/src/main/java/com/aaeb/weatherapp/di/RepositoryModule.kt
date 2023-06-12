package com.aaeb.weatherapp.di

import com.aaeb.weatherapp.data.repository.WeatherRepoImpl
import com.aaeb.weatherapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(weatherRepoImpl: WeatherRepoImpl): WeatherRepository
}