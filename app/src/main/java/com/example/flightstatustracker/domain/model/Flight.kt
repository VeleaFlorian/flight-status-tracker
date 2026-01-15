package com.example.flightstatustracker.domain.model

data class Flight(
    val id: String,
    val date: String,
    val status: String,
    val departureAirport: String,
    val departureTimezone: String?,
    val departureIata: String,
    val departureIcao: String?,
    val departureTerminal: String?,
    val departureGate: String?,
    val departureDelay: Int?,
    val departureScheduled: String,
    val departureEstimated: String?,
    val departureActual: String?,
    
    val arrivalAirport: String,
    val arrivalTimezone: String?,
    val arrivalIata: String,
    val arrivalIcao: String?,
    val arrivalTerminal: String?,
    val arrivalGate: String?,
    val arrivalDelay: Int?,
    val arrivalScheduled: String,
    val arrivalEstimated: String?,
    val arrivalActual: String?,
    
    val airlineName: String,
    val airlineIata: String?,
    val airlineIcao: String?,
    
    val flightNumber: String,
    val flightIata: String,
    val flightIcao: String?,
    
    val delay: Int
)
