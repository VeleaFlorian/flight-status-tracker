package com.example.flightstatustracker.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flightstatustracker.common.Resource
import com.example.flightstatustracker.domain.repository.FlightRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FlightViewModel @Inject constructor(
    private val repository: FlightRepository
) : ViewModel() {

    private val _state = MutableStateFlow(FlightState())
    val state: StateFlow<FlightState> = _state.asStateFlow()

    private var searchJob: Job? = null
    private var loadJob: Job? = null

    init {
        getFlights()
    }

    fun onEvent(event: FlightEvent) {
        when (event) {
            is FlightEvent.Refresh -> {
                getFlights(fetchFromRemote = true)
            }
            is FlightEvent.OnSearchQueryChange -> {
                _state.value = _state.value.copy(searchQuery = event.query)
                searchJob?.cancel()
                if (event.query.isNotBlank()) {
                    loadJob?.cancel()
                }
                searchJob = viewModelScope.launch {
                    delay(300L) 
                    searchFlights(event.query)
                }
            }
        }
    }

    private fun getFlights(fetchFromRemote: Boolean = false) {
        loadJob?.cancel()
        loadJob = repository.getFlights(fetchFromRemote)
            .onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = _state.value.copy(
                            flights = result.data ?: emptyList(),
                            isLoading = false,
                            error = null
                        )
                    }
                    is Resource.Error -> {
                        _state.value = _state.value.copy(
                            flights = result.data ?: emptyList(),
                            isLoading = false,
                            error = result.message ?: "An unexpected error occurred"
                        )
                    }
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(
                            isLoading = true
                        )
                    }
                }
            }.launchIn(viewModelScope)
    }
    
    private suspend fun searchFlights(query: String) {
        if(query.isBlank()) {
            getFlights(fetchFromRemote = false) // Reset to show all cached
            return
        }
        
        repository.searchFlights(query)
            .onEach { flights ->
                _state.value = _state.value.copy(
                    flights = flights,
                    isLoading = false,
                    error = null
                )
            }.launchIn(viewModelScope)
    }

    suspend fun getFlightById(id: String): com.example.flightstatustracker.domain.model.Flight? {
        return repository.getFlightById(id)
    }
}
