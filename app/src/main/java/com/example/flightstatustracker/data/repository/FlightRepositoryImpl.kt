package com.example.flightstatustracker.data.repository

import com.example.flightstatustracker.common.Resource
import com.example.flightstatustracker.data.local.AppDatabase
import com.example.flightstatustracker.data.mapper.toFlight
import com.example.flightstatustracker.data.mapper.toFlightEntity
import com.example.flightstatustracker.data.remote.FlightApiService
import com.example.flightstatustracker.domain.model.Flight
import com.example.flightstatustracker.domain.repository.FlightRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class FlightRepositoryImpl @Inject constructor(
    private val api: FlightApiService,
    private val db: AppDatabase
) : FlightRepository {

    private val dao = db.flightDao

    override fun getFlights(fetchFromRemote: Boolean): Flow<Resource<List<Flight>>> = flow {
        emit(Resource.Loading(true))
        
        try {
            if (fetchFromRemote) {
                val response = api.getFlights("API-KEY") 
                val flightEntities = response.data.map { it.toFlightEntity() }
                
                dao.clearFlights()
                dao.insertFlights(flightEntities)
            }
        } catch(e: IOException) {
            e.printStackTrace()
            emit(Resource.Error("Couldn't load data"))
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Resource.Error("Couldn't load data"))
        }

        dao.getAllFlights().collect { entities ->
             emit(Resource.Success(entities.map { it.toFlight() }))
        }
    }

    override suspend fun searchFlights(query: String): Flow<List<Flight>> = flow {
        val local = dao.searchFlights(query).first()
        
        try {
            val response = when {
                query.matches(Regex("^[A-Za-z]{2}\\d+$", RegexOption.IGNORE_CASE)) -> {
                    api.searchFlights("API-KEY", flightIata = query)
                }
                query.length == 3 && query.all { it.isLetter() } -> {
                    api.searchFlights("API-KEY", departureIata = query)
                }
                else -> {
                     api.searchFlights("API-KEY", airlineName = query)
                }
            }
            
            if (response.data.isNotEmpty()) {
                dao.insertFlights(response.data.map { it.toFlightEntity() })
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
            
        emitAll(dao.searchFlights(query).map { entities -> 
            entities.map { it.toFlight() } 
        })
    }

    override suspend fun getFlightById(id: String): Flight? {
        return dao.getFlightById(id)?.toFlight()
    }
}
