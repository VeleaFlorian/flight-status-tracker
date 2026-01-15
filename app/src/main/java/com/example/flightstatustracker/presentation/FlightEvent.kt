package com.example.flightstatustracker.presentation

sealed class FlightEvent {
    object Refresh : FlightEvent()
    data class OnSearchQueryChange(val query: String) : FlightEvent()
}
