package com.example.flightstatustracker.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.flightstatustracker.data.local.dao.FlightDao
import com.example.flightstatustracker.data.local.entity.FlightEntity

@Database(entities = [FlightEntity::class], version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val flightDao: FlightDao
}
