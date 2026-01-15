package com.example.flightstatustracker.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flights")
data class FlightEntity(
    @PrimaryKey
    val id: String, // Combination of flight number and date unique identifier
    val date: String,
    val status: String,
    
    // Departure
    // Departure
    val departureAirport: String?,
    val departureTimezone: String?,
    val departureIata: String?,
    val departureIcao: String?,
    val departureTerminal: String?,
    val departureGate: String?,
    val departureDelay: Int?,
    val departureScheduled: String?,
    val departureEstimated: String?,
    val departureActual: String?,
    
    // Arrival
    val arrivalAirport: String?,
    val arrivalTimezone: String?,
    val arrivalIata: String?,
    val arrivalIcao: String?,
    val arrivalTerminal: String?,
    val arrivalGate: String?,
    val arrivalDelay: Int?,
    val arrivalScheduled: String?,
    val arrivalEstimated: String?,
    val arrivalActual: String?,
    
    // Airline
    val airlineName: String?,
    val airlineIata: String?,
    val airlineIcao: String?,
    
    // Flight Info
    val flightNumber: String?,
    val flightIata: String?,
    val flightIcao: String?
)
