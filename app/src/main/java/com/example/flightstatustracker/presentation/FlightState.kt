package com.example.flightstatustracker.presentation

import com.example.flightstatustracker.domain.model.Flight

data class FlightState(
    val flights: List<Flight> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val searchQuery: String = ""
)
