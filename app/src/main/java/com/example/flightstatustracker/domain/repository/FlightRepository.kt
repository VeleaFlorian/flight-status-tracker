package com.example.flightstatustracker.domain.repository

import com.example.flightstatustracker.common.Resource
import com.example.flightstatustracker.domain.model.Flight
import kotlinx.coroutines.flow.Flow

interface FlightRepository {
    fun getFlights(fetchFromRemote: Boolean): Flow<Resource<List<Flight>>>
    suspend fun searchFlights(query: String): Flow<List<Flight>>
    suspend fun getFlightById(id: String): Flight?
}
