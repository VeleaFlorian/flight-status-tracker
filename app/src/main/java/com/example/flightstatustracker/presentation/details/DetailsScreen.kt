package com.example.flightstatustracker.presentation.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.flightstatustracker.domain.model.Flight
import com.example.flightstatustracker.presentation.FlightViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    navController: NavController,
    flightId: String,
    viewModel: FlightViewModel = hiltViewModel()
) {
    val flightState = produceState<Flight?>(initialValue = null, key1 = flightId) {
        value = viewModel.getFlightById(flightId)
    }
    
    val flight = flightState.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Flight Details", style = MaterialTheme.typography.titleLarge) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { padding ->
        Box(modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .padding(16.dp)) {
            
            if (flight != null) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    // Header Card
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = flight.airlineName,
                                style = MaterialTheme.typography.headlineSmall,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = flight.flightNumber,
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = flight.date,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.outline
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                StatusChip(status = flight.status)
                            }
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(24.dp))

                    // Route Card
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Departure
                                Column(horizontalAlignment = Alignment.Start) {
                                    Text(
                                        text = flight.departureIata,
                                        style = MaterialTheme.typography.displayMedium,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                    Text(text = flight.departureAirport, style = MaterialTheme.typography.bodySmall, modifier = Modifier.width(100.dp))
                                    if(flight.departureIcao != null) Text(text = "ICAO: ${flight.departureIcao}", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.outline)
                                }

                                // Arrow
                                Icon(
                                    imageVector = Icons.Default.ArrowForward,
                                    contentDescription = "To",
                                    modifier = Modifier.size(32.dp),
                                    tint = MaterialTheme.colorScheme.outline
                                )

                                // Arrival
                                Column(horizontalAlignment = Alignment.End) {
                                    Text(
                                        text = flight.arrivalIata,
                                        style = MaterialTheme.typography.displayMedium,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                    Text(text = flight.arrivalAirport, style = MaterialTheme.typography.bodySmall, modifier = Modifier.width(100.dp), textAlign = androidx.compose.ui.text.style.TextAlign.End)
                                    if(flight.arrivalIcao != null) Text(text = "ICAO: ${flight.arrivalIcao}", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.outline)
                                }
                            }
                            
                            Spacer(modifier = Modifier.height(16.dp))
                            Divider()
                            Spacer(modifier = Modifier.height(16.dp))
                            
                            // Info Grid
                            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                Column {
                                    Text("Departure Info", style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.primary)
                                    if (!flight.departureTerminal.isNullOrBlank()) Text("Terminal: ${flight.departureTerminal}")
                                    if (!flight.departureGate.isNullOrBlank()) Text("Gate: ${flight.departureGate}")
                                    if (!flight.departureTimezone.isNullOrBlank()) Text("Timezone: ${flight.departureTimezone}", style = MaterialTheme.typography.labelSmall)
                                }
                                Column(horizontalAlignment = Alignment.End) {
                                    Text("Arrival Info", style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.primary)
                                    if (!flight.arrivalTerminal.isNullOrBlank()) Text("Terminal: ${flight.arrivalTerminal}")
                                    if (!flight.arrivalGate.isNullOrBlank()) Text("Gate: ${flight.arrivalGate}")
                                    if (!flight.arrivalTimezone.isNullOrBlank()) Text("Timezone: ${flight.arrivalTimezone}", style = MaterialTheme.typography.labelSmall)
                                }
                            }
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))

                    // Timing Card
                    Card(modifier = Modifier.fillMaxWidth()) {
                         Column(modifier = Modifier.padding(16.dp)) {
                             Text("Timing Details", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
                             Spacer(modifier = Modifier.height(8.dp))
                             
                             Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                 Column {
                                     Text("Scheduled", style = MaterialTheme.typography.labelLarge)
                                     Text("Dep: ${flight.departureScheduled.replace("T", " ")}")
                                     Text("Arr: ${flight.arrivalScheduled.replace("T", " ")}")
                                 }
                                 
                                 if (flight.departureActual != null || flight.arrivalActual != null) {
                                     Column(horizontalAlignment = Alignment.End) {
                                         Text("Actual", style = MaterialTheme.typography.labelLarge)
                                         Text("Dep: ${flight.departureActual?.replace("T", " ") ?: "-"}")
                                         Text("Arr: ${flight.arrivalActual?.replace("T", " ") ?: "-"}")
                                     }
                                 }
                             }
                             
                             if (flight.departureEstimated != null || flight.arrivalEstimated != null) {
                                 Spacer(modifier = Modifier.height(8.dp))
                                 Text("Estimated", style = MaterialTheme.typography.labelLarge)
                                 Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                      Text("Dep: ${flight.departureEstimated?.replace("T", " ") ?: "-"}")
                                      Text("Arr: ${flight.arrivalEstimated?.replace("T", " ") ?: "-"}")
                                 }
                             }
                         }
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Extra Info
                    if((flight.departureDelay ?: 0) > 0 || (flight.arrivalDelay ?: 0) > 0) {
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.errorContainer
                            )
                        ) {
                            Row(modifier = Modifier.padding(16.dp)) {
                                Icon(Icons.Default.Warning, contentDescription = "Delay", tint = MaterialTheme.colorScheme.onErrorContainer)
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                     if ((flight.departureDelay ?: 0) > 0) Text("Departure Delayed by ${flight.departureDelay} min", color = MaterialTheme.colorScheme.onErrorContainer)
                                     if ((flight.arrivalDelay ?: 0) > 0) Text("Arrival Delayed by ${flight.arrivalDelay} min", color = MaterialTheme.colorScheme.onErrorContainer)
                                }
                                
                            }
                        }
                    }
                }
            } else {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}

@Composable
fun StatusChip(status: String) {
    val (containerColor, contentColor) = when (status.lowercase()) {
        "active" -> MaterialTheme.colorScheme.primaryContainer to MaterialTheme.colorScheme.onPrimaryContainer
        "scheduled" -> MaterialTheme.colorScheme.secondaryContainer to MaterialTheme.colorScheme.onSecondaryContainer
        "landed" -> MaterialTheme.colorScheme.tertiaryContainer to MaterialTheme.colorScheme.onTertiaryContainer
        "cancelled" -> MaterialTheme.colorScheme.errorContainer to MaterialTheme.colorScheme.onErrorContainer
        else -> MaterialTheme.colorScheme.surfaceVariant to MaterialTheme.colorScheme.onSurfaceVariant
    }

    Surface(
        color = containerColor,
        contentColor = contentColor,
        shape = MaterialTheme.shapes.small
    ) {
        Text(
            text = status.uppercase(),
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            style = MaterialTheme.typography.labelSmall
        )
    }
}
