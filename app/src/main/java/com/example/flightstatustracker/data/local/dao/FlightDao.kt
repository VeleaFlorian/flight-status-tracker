package com.example.flightstatustracker.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.flightstatustracker.data.local.entity.FlightEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FlightDao {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFlights(flights: List<FlightEntity>)
    
    @Query("DELETE FROM flights")
    suspend fun clearFlights()
    
    @Query("SELECT * FROM flights")
    fun getAllFlights(): Flow<List<FlightEntity>>
    
    @Query("""
        SELECT * FROM flights 
        WHERE flightIata LIKE '%' || :query || '%' 
        OR airlineName LIKE '%' || :query || '%' 
        OR departureAirport LIKE '%' || :query || '%'
        OR arrivalAirport LIKE '%' || :query || '%'
    """)
    fun searchFlights(query: String): Flow<List<FlightEntity>>

    @Query("SELECT * FROM flights WHERE id = :flightId")
    suspend fun getFlightById(flightId: String): FlightEntity?
}
