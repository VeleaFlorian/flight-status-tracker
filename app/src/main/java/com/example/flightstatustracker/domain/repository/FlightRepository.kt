package com.example.flightstatustracker.domain.repository

import com.example.flightstatustracker.common.Resource
import com.example.flightstatustracker.domain.model.Flight
import kotlinx.coroutines.flow.Flow

interface FlightRepository {
    /**
     * Fetches flights from the local database or remote API.
     *
     * @param fetchFromRemote Whether to fetch from the remote API.
     * @return A Flow of Resource<List<Flight>>.
     */
    fun getFlights(fetchFromRemote: Boolean): Flow<Resource<List<Flight>>>
    
    /**
     * Searches for flights based on the query.
     * 
     * @param query The search query.
     * @return A Flow of List<Flight>.
     */
    suspend fun searchFlights(query: String): Flow<List<Flight>>
    
    /**
     * Retrieves a flight by its ID.
     *
     * @param id The ID of the flight.
     * @return The Flight object if found, null otherwise.
     */
    suspend fun getFlightById(id: String): Flight?
}
