package com.example.myapplication

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WeatherLocationDao {
    @Query("SELECT * FROM weather_location LIMIT 1")
    suspend fun getLastWeatherLocation(): WeatherLocation?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeatherLocation(weatherLocation: WeatherLocation)
}
