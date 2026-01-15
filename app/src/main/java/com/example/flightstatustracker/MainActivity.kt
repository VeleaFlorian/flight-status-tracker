package com.example.flightstatustracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FlightApp()
                }
            }
        }
    }
}

@Composable
fun FlightApp() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            com.example.flightstatustracker.presentation.home.HomeScreen(navController = navController)
        }
        composable("details/{flightId}") { backStackEntry ->
             val flightId = backStackEntry.arguments?.getString("flightId") ?: return@composable
             com.example.flightstatustracker.presentation.details.DetailsScreen(
                 navController = navController,
                 flightId = flightId
             )
        }
    }
}
