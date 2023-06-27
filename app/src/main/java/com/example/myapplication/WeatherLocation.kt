package com.example.myapplication

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "weather_location")
    data class WeatherLocation(
    @PrimaryKey val id: Int,
    val latitude: Double,
    val longitude: Double
)