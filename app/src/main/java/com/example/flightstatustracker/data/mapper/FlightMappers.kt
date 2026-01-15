package com.example.flightstatustracker.data.mapper

import com.example.flightstatustracker.data.local.entity.FlightEntity
import com.example.flightstatustracker.data.remote.dto.FlightDto
import com.example.flightstatustracker.domain.model.Flight

fun FlightDto.toFlightEntity(): FlightEntity {
    val fIata = flightInfo?.iata ?: "UNKNOWN"
    val fDate = flightDate ?: "UNKNOWN"
    val uniqueId = "${fDate}_${fIata}"

    return FlightEntity(
        id = uniqueId,
        date = flightDate ?: "",
        status = flightStatus ?: "",
        departureAirport = departure?.airport ?: "",
        departureTimezone = departure?.timezone,
        departureIata = departure?.iata ?: "",
        departureIcao = departure?.icao,
        departureTerminal = departure?.terminal,
        departureGate = departure?.gate,
        departureDelay = departure?.delay,
        departureScheduled = departure?.scheduled ?: "",
        departureEstimated = departure?.estimated,
        departureActual = departure?.actual,
        
        arrivalAirport = arrival?.airport ?: "",
        arrivalTimezone = arrival?.timezone,
        arrivalIata = arrival?.iata ?: "",
        arrivalIcao = arrival?.icao,
        arrivalTerminal = arrival?.terminal,
        arrivalGate = arrival?.gate,
        arrivalDelay = arrival?.delay,
        arrivalScheduled = arrival?.scheduled ?: "",
        arrivalEstimated = arrival?.estimated,
        arrivalActual = arrival?.actual,
        
        airlineName = airline?.name ?: "",
        airlineIata = airline?.iata,
        airlineIcao = airline?.icao,
        
        flightNumber = flightInfo?.number ?: "",
        flightIata = flightInfo?.iata ?: "",
        flightIcao = flightInfo?.icao
    )
}

fun FlightEntity.toFlight(): Flight {
    return Flight(
        id = id,
        date = date,
        status = status,
        
        departureAirport = departureAirport ?: "Unknown",
        departureTimezone = departureTimezone,
        departureIata = departureIata ?: "N/A",
        departureIcao = departureIcao,
        departureTerminal = departureTerminal,
        departureGate = departureGate,
        departureDelay = departureDelay,
        departureScheduled = departureScheduled ?: "TBD",
        departureEstimated = departureEstimated,
        departureActual = departureActual,

        arrivalAirport = arrivalAirport ?: "Unknown",
        arrivalTimezone = arrivalTimezone,
        arrivalIata = arrivalIata ?: "N/A",
        arrivalIcao = arrivalIcao,
        arrivalTerminal = arrivalTerminal,
        arrivalGate = arrivalGate,
        arrivalDelay = arrivalDelay,
        arrivalScheduled = arrivalScheduled ?: "TBD",
        arrivalEstimated = arrivalEstimated,
        arrivalActual = arrivalActual,
        
        airlineName = airlineName ?: "Unknown Airline",
        airlineIata = airlineIata,
        airlineIcao = airlineIcao,
        
        flightNumber = flightNumber ?: "",
        flightIata = flightIata ?: "",
        flightIcao = flightIcao,
        
        delay = departureDelay ?: arrivalDelay ?: 0
    )
}
