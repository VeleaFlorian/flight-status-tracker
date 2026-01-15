package com.example.flightstatustracker.data.remote.dto

import com.google.gson.annotations.SerializedName

data class FlightResponse(
    @SerializedName("data")
    val data: List<FlightDto>,
    @SerializedName("pagination")
    val pagination: PaginationDto
)

data class PaginationDto(
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("count")
    val count: Int,
    @SerializedName("total")
    val total: Int
)

data class FlightDto(
    @SerializedName("flight_date")
    val flightDate: String?,
    @SerializedName("flight_status")
    val flightStatus: String?,
    @SerializedName("departure")
    val departure: AirportInfoDto?,
    @SerializedName("arrival")
    val arrival: AirportInfoDto?,
    @SerializedName("airline")
    val airline: AirlineDto?,
    @SerializedName("flight")
    val flightInfo: FlightInfoDto?
)

data class AirportInfoDto(
    @SerializedName("airport")
    val airport: String?,
    @SerializedName("timezone")
    val timezone: String?,
    @SerializedName("iata")
    val iata: String?,
    @SerializedName("icao")
    val icao: String?,
    @SerializedName("terminal")
    val terminal: String?,
    @SerializedName("gate")
    val gate: String?,
    @SerializedName("scheduled")
    val scheduled: String?,
    @SerializedName("estimated")
    val estimated: String?,
    @SerializedName("actual")
    val actual: String?,
    @SerializedName("delay")
    val delay: Int?
)

data class AirlineDto(
    @SerializedName("name")
    val name: String?,
    @SerializedName("iata")
    val iata: String?,
    @SerializedName("icao")
    val icao: String?
)

data class FlightInfoDto(
    @SerializedName("number")
    val number: String?,
    @SerializedName("iata")
    val iata: String?,
    @SerializedName("icao")
    val icao: String?
)
