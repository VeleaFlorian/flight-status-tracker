package com.example.flightstatustracker.data.remote

import com.example.flightstatustracker.data.remote.dto.FlightResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FlightApiService {
    
    @GET("flights")
    suspend fun getFlights(
        @Query("access_key") apiKey: String,
        @Query("limit") limit: Int = 100
    ): FlightResponse

    @GET("flights")
    suspend fun searchFlights(
        @Query("access_key") apiKey: String,
        @Query("flight_iata") flightIata: String? = null,
        @Query("arr_iata") arrivalIata: String? = null,
        @Query("dep_iata") departureIata: String? = null,
        @Query("airline_name") airlineName: String? = null
    ): FlightResponse
}
